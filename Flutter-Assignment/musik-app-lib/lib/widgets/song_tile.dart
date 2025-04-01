import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:music_app/models/song.dart';
import 'package:music_app/providers/audio_provider.dart';

class SongTile extends StatelessWidget {
  final Song song;

  const SongTile({super.key, required this.song});

  @override
  Widget build(BuildContext context) {
    final audioProvider = Provider.of<AudioProvider>(context, listen: false);

    return ListTile(
      leading: ClipRRect(
        borderRadius: BorderRadius.circular(8),
        child: Image.network(
          song.imageUrl,
          width: 56,
          height: 56,
          fit: BoxFit.cover,
          errorBuilder: (context, error, stackTrace) => Container(
            width: 56,
            height: 56,
            color: Color(0xFF282828),
            child: Icon(Icons.music_note, color: Color(0xFFB3B3B3), size: 30),
          ),
        ),
      ),
      title: Text(
        song.title,
        style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
        overflow: TextOverflow.ellipsis,
      ),
      subtitle: Text(
        song.artist,
        style: TextStyle(color: Color(0xFFB3B3B3)),
        overflow: TextOverflow.ellipsis,
      ),
      trailing: IconButton(
        icon: Icon(
          audioProvider.isPlaying && audioProvider.currentSong == song
              ? Icons.pause
              : Icons.play_arrow,
          color: Color(0xFF1DB954),
        ),
        onPressed: () {
          if (audioProvider.isPlaying && audioProvider.currentSong == song) {
            audioProvider.pause();
          } else {
            audioProvider.play(song);
          }
        },
      ),
    );
  }
}
