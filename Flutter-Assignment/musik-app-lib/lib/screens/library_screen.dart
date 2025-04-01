import 'package:flutter/material.dart';
import 'package:music_app/models/song.dart';
import 'package:music_app/services/firebase_service.dart';
import 'package:music_app/widgets/song_tile.dart';

class LibraryScreen extends StatelessWidget {
  final FirebaseService _firebaseService = FirebaseService();

  LibraryScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return StreamBuilder<List<Song>>(
      stream: _firebaseService.getSongs(),
      builder: (context, snapshot) {
        if (!snapshot.hasData) {
          return Center(
              child: CircularProgressIndicator(color: Color(0xFF1DB954)));
        }
        final songs = snapshot.data!;
        return ListView.builder(
          itemCount: songs.length,
          itemBuilder: (context, index) => SongTile(song: songs[index]),
        );
      },
    );
  }
}
