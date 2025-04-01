import 'package:flutter/material.dart';
import 'package:music_app/models/song.dart';
import 'package:music_app/services/firebase_service.dart';
import 'package:music_app/widgets/song_tile.dart';

class ArtistSongsScreen extends StatelessWidget {
  final String artistName;
  final FirebaseService _firebaseService = FirebaseService();

  ArtistSongsScreen({super.key, required this.artistName});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          artistName,
          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
        ),
      ),
      body: StreamBuilder<List<Song>>(
        stream: _firebaseService.getSongs(),
        builder: (context, snapshot) {
          if (!snapshot.hasData) {
            return Center(
                child: CircularProgressIndicator(color: Color(0xFF1DB954)));
          }
          final songs = snapshot.data!
              .where((song) => song.artist == artistName)
              .toList();
          if (songs.isEmpty) {
            return Center(
              child: Text(
                'No songs found for $artistName',
                style: TextStyle(fontSize: 18, color: Color(0xFFB3B3B3)),
              ),
            );
          }
          return ListView.builder(
            itemCount: songs.length,
            itemBuilder: (context, index) => SongTile(song: songs[index]),
          );
        },
      ),
    );
  }
}
