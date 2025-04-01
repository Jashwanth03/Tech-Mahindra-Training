import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:music_app/providers/audio_provider.dart';

class PlayerControls extends StatelessWidget {
  const PlayerControls({super.key});

  @override
  Widget build(BuildContext context) {
    final audioProvider = Provider.of<AudioProvider>(context);

    return Container(
      color: Color(0xFF282828),
      padding: EdgeInsets.symmetric(vertical: 8, horizontal: 16),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          if (audioProvider.currentSong != null)
            Expanded(
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    audioProvider.currentSong!.title,
                    style: TextStyle(
                        color: Colors.white,
                        fontWeight: FontWeight.bold,
                        overflow: TextOverflow.ellipsis),
                    maxLines: 1,
                  ),
                  Text(
                    audioProvider.currentSong!.artist,
                    style: TextStyle(
                        color: Color(0xFFB3B3B3),
                        overflow: TextOverflow.ellipsis),
                    maxLines: 1,
                  ),
                ],
              ),
            ),
          IconButton(
            icon: Icon(
              audioProvider.isPlaying ? Icons.pause : Icons.play_arrow,
              color: Color(0xFF1DB954),
            ),
            onPressed: () {
              if (audioProvider.isPlaying) {
                audioProvider.pause();
              } else if (audioProvider.currentSong != null) {
                audioProvider.play(audioProvider.currentSong!);
              }
            },
          ),
        ],
      ),
    );
  }
}
