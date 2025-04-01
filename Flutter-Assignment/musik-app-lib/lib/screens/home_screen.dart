import 'package:flutter/material.dart';
import 'package:music_app/generated/l10n.dart';
import 'package:music_app/screens/search_screen.dart';
import 'package:music_app/screens/library_screen.dart';
import 'package:music_app/widgets/artist_grid_widget.dart';
import 'package:music_app/widgets/player_controls.dart';

class HomeScreen extends StatefulWidget {
  final Function(Locale) onLocaleChange;

  const HomeScreen({super.key, required this.onLocaleChange});

  @override
  _HomeScreenState createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  int _selectedIndex = 0;

  Widget _homePage() {
    return SingleChildScrollView(
      child: Column(
        children: [
          ArtistGridWidget(),
          SizedBox(height: 16),
        ],
      ),
    );
  }

  final List<Widget> _screens = [
    Container(), // Placeholder for _homePage()
    SearchScreen(),
    LibraryScreen(),
  ];

  void _onItemTapped(int index) {
    setState(() {
      _selectedIndex = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          'Westify',
          style: TextStyle(color: Colors.white, fontWeight: FontWeight.bold),
        ),
        actions: [
          Padding(
            padding: EdgeInsets.only(right: 16.0),
            child: DropdownButton<Locale>(
              value: Localizations.localeOf(context),
              //icon: Icon(Icons.language, color: Colors.white),
              dropdownColor: Color(0xFF282828),
              underline: SizedBox(),
              style: TextStyle(color: Colors.white, fontSize: 16),
              selectedItemBuilder: (BuildContext context) {
                return [
                  Locale('en'),
                  Locale('ta'),
                ].map<Widget>((Locale locale) {
                  return Padding(
                    padding: EdgeInsets.symmetric(horizontal: 8.0),
                    child: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Text(
                          locale.languageCode == 'en' ? 'English' : 'தமிழ்',
                          style: TextStyle(
                            color: Color(0xFF1DB954),
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        SizedBox(width: 4),
                        Icon(Icons.language,
                            color: Color(0xFF1DB954), size: 16),
                      ],
                    ),
                  );
                }).toList();
              },
              items: [
                DropdownMenuItem(
                    value: Locale('en'),
                    child:
                        Text('English', style: TextStyle(color: Colors.white))),
                DropdownMenuItem(
                    value: Locale('ta'),
                    child:
                        Text('தமிழ்', style: TextStyle(color: Colors.white))),
              ],
              onChanged: (Locale? newLocale) {
                if (newLocale != null) {
                  widget.onLocaleChange(newLocale);
                }
              },
            ),
          ),
        ],
      ),
      body: Column(
        children: [
          Expanded(
              child:
                  _selectedIndex == 0 ? _homePage() : _screens[_selectedIndex]),
          PlayerControls(),
        ],
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(
              icon: Icon(Icons.home),
              label: AppLocalizations.of(context)!.home),
          BottomNavigationBarItem(
              icon: Icon(Icons.search),
              label: AppLocalizations.of(context)!.search),
          BottomNavigationBarItem(
              icon: Icon(Icons.library_music),
              label: AppLocalizations.of(context)!.library),
        ],
        currentIndex: _selectedIndex,
        selectedItemColor: Color(0xFF1DB954),
        unselectedItemColor: Color(0xFFB3B3B3),
        onTap: _onItemTapped,
        type: BottomNavigationBarType.fixed,
      ),
    );
  }
}
