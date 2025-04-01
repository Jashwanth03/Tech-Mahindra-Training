import 'package:flutter/material.dart';
import 'package:music_app/generated/l10n.dart';
import 'package:music_app/models/song.dart';
import 'package:music_app/services/firebase_service.dart';
import 'package:music_app/widgets/song_tile.dart';

class SearchScreen extends StatefulWidget {
  const SearchScreen({super.key});

  @override
  _SearchScreenState createState() => _SearchScreenState();
}

class _SearchScreenState extends State<SearchScreen> {
  final FirebaseService _firebaseService = FirebaseService();
  final TextEditingController _searchController = TextEditingController();
  List<Song> _songs = [];
  List<Song> _filteredSongs = [];

  @override
  void initState() {
    super.initState();
    _loadSongs();
    _searchController.addListener(_filterSongs);
  }

  Future<void> _loadSongs() async {
    final songs = await _firebaseService.getSongs().first;
    setState(() {
      _songs = songs;
      _filteredSongs = songs;
    });
  }

  void _filterSongs() {
    final query = _searchController.text.toLowerCase();
    setState(() {
      _filteredSongs = _songs.where((song) {
        return song.title.toLowerCase().contains(query) ||
            song.artist.toLowerCase().contains(query);
      }).toList();
    });
  }

  @override
  void dispose() {
    _searchController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Padding(
          padding: EdgeInsets.all(16.0),
          child: TextField(
            controller: _searchController,
            decoration: InputDecoration(
              hintText: AppLocalizations.of(context)!.search,
              hintStyle: TextStyle(color: Color(0xFFB3B3B3)),
              filled: true,
              fillColor: Color(0xFF333333),
              border: OutlineInputBorder(
                borderRadius: BorderRadius.circular(8),
                borderSide: BorderSide.none,
              ),
            ),
            style: TextStyle(color: Colors.white),
          ),
        ),
        Expanded(
          child: ListView.builder(
            itemCount: _filteredSongs.length,
            itemBuilder: (context, index) =>
                SongTile(song: _filteredSongs[index]),
          ),
        ),
      ],
    );
  }
}
