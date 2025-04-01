import 'package:flutter/material.dart';
import 'package:audioplayers/audioplayers.dart';
import 'package:music_app/models/song.dart';

class AudioProvider with ChangeNotifier {
  final AudioPlayer _audioPlayer = AudioPlayer();
  Song? _currentSong;
  bool _isPlaying = false;

  Song? get currentSong => _currentSong;
  bool get isPlaying => _isPlaying;

  Future<void> play(Song song) async {
    try {
      if (_currentSong != song) {
        await _audioPlayer.stop(); // Stop current playback
        _currentSong = song;
        await _audioPlayer
            .play(UrlSource(song.audioUrl)); // Play from GitHub URL
        _isPlaying = true;
      } else if (!_isPlaying) {
        await _audioPlayer.resume();
        _isPlaying = true;
      }
      notifyListeners();
    } catch (e) {
      print('Playback error: $e');
      rethrow;
    }
  }

  Future<void> pause() async {
    try {
      if (_isPlaying) {
        await _audioPlayer.pause();
        _isPlaying = false;
        notifyListeners();
      }
    } catch (e) {
      print('Pause error: $e');
      rethrow;
    }
  }

  Future<void> stop() async {
    try {
      await _audioPlayer.stop();
      _currentSong = null;
      _isPlaying = false;
      notifyListeners();
    } catch (e) {
      print('Stop error: $e');
      rethrow;
    }
  }

  @override
  void dispose() {
    _audioPlayer.dispose();
    super.dispose();
  }
}
