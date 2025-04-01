import 'package:flutter/material.dart';
import 'package:music_app/models/song.dart';
import 'package:music_app/services/firebase_service.dart';
import 'package:music_app/screens/artist_songs_screen.dart';

class ArtistGridWidget extends StatefulWidget {
  const ArtistGridWidget({super.key});

  @override
  _ArtistGridWidgetState createState() => _ArtistGridWidgetState();
}

class _ArtistGridWidgetState extends State<ArtistGridWidget> {
  final FirebaseService _firebaseService = FirebaseService();
  Map<String, String> _artistImages = {};
  bool _isLoading = true;

  @override
  void initState() {
    super.initState();
    _loadArtists();
  }

  Future<void> _loadArtists() async {
    setState(() => _isLoading = true);
    try {
      final songs = await _firebaseService.getSongs().first;
      _artistImages = _groupArtists(songs);
    } catch (e) {
      print('Error loading artists: $e');
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Failed to load artists: $e')),
      );
    } finally {
      setState(() => _isLoading = false);
    }
  }

  Map<String, String> _groupArtists(List<Song> songs) {
    final Map<String, String> artists = {};
    for (var song in songs) {
      if (!artists.containsKey(song.artist) && song.imageUrl.isNotEmpty) {
        artists[song.artist] = song.imageUrl;
      }
    }
    return artists;
  }

  @override
  Widget build(BuildContext context) {
    return _isLoading
        ? Center(child: CircularProgressIndicator(color: Color(0xFF1DB954)))
        : Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Padding(
                padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Text(
                      'Best of Artists',
                      style: TextStyle(
                        color: Colors.white,
                        fontSize: 20,
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                    TextButton(
                      onPressed: () {
                        print('Show All clicked');
                      },
                      child: Text(
                        'SHOW ALL',
                        style:
                            TextStyle(color: Color(0xFFB3B3B3), fontSize: 12),
                      ),
                    ),
                  ],
                ),
              ),
              Padding(
                padding: EdgeInsets.symmetric(horizontal: 16, vertical: 8),
                child: GridView.count(
                  crossAxisCount: 2,
                  crossAxisSpacing: 16,
                  mainAxisSpacing: 16,
                  childAspectRatio: 0.75,
                  scrollDirection: Axis.vertical,
                  physics: NeverScrollableScrollPhysics(),
                  shrinkWrap: true,
                  children: _artistImages.entries.map((entry) {
                    String artist = entry.key;
                    String imageUrl = entry.value;
                    return GestureDetector(
                      onTap: () {
                        Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) =>
                                ArtistSongsScreen(artistName: artist),
                          ),
                        );
                      },
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          ClipRRect(
                            borderRadius: BorderRadius.circular(8),
                            child: Image.network(
                              imageUrl,
                              width: double.infinity,
                              height: 120,
                              fit: BoxFit.cover,
                              errorBuilder: (context, error, stackTrace) =>
                                  Container(
                                width: double.infinity,
                                height: 120,
                                color: Color(0xFF282828),
                                child: Icon(Icons.person,
                                    color: Color(0xFFB3B3B3), size: 40),
                              ),
                            ),
                          ),
                          SizedBox(height: 8),
                          Text(
                            artist,
                            style: TextStyle(
                              color: Colors.white,
                              fontWeight: FontWeight.bold,
                              fontSize: 14,
                            ),
                            overflow: TextOverflow.ellipsis,
                            maxLines: 1,
                          ),
                          Text(
                            'This is $artist. The essential tracks, all in one.',
                            style: TextStyle(
                              color: Color(0xFFB3B3B3),
                              fontSize: 12,
                            ),
                            overflow: TextOverflow.ellipsis,
                            maxLines: 2,
                          ),
                        ],
                      ),
                    );
                  }).toList(),
                ),
              ),
            ],
          );
  }
}
