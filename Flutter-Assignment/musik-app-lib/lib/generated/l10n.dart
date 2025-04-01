import 'dart:async';
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
// import 'package:intl/intl.dart';

class AppLocalizations {
  AppLocalizations(this.locale);

  final Locale locale;

  static const AppLocalizationsDelegate delegate = AppLocalizationsDelegate();

  static Future<AppLocalizations> load(Locale locale) {
    return SynchronousFuture<AppLocalizations>(AppLocalizations(locale));
  }

  static AppLocalizations? of(BuildContext context) {
    return Localizations.of<AppLocalizations>(context, AppLocalizations);
  }

  final Map<String, String> _enTranslations = {
    "appTitle": "Music App",
    "home": "Home",
    "search": "Search",
    "library": "Library",
    "play": "Play",
    "pause": "Pause",
    "addSong": "Add Song",
    "title": "Title",
    "artist": "Artist",
    "audioUrl": "Audio URL",
    "imageUrl": "Image URL",
    "add": "Add",
    "cancel": "Cancel",
    "fillAllFields": "Please fill all fields",
    "enterSearchTerm": "Enter a search term",
    "noSongsFound": "No songs found",
  };

  final Map<String, String> _taTranslations = {
    "appTitle": "இசை பயன்பாடு",
    "home": "முகப்பு",
    "search": "தேடல்",
    "library": "நூலகம்",
    "play": "இயக்கு",
    "pause": "நிறுத்து",
    "addSong": "பாடலை சேர்",
    "title": "தலைப்பு",
    "artist": "கலைஞர்",
    "audioUrl": "ஆடியோ URL",
    "imageUrl": "பட URL",
    "add": "சேர்",
    "cancel": "ரத்து செய்",
    "fillAllFields": "அனைத்து புலங்களையும் நிரப்பவும்",
    "enterSearchTerm": "தேடல் சொல்லை உள்ளிடவும்",
    "noSongsFound": "பாடல்கள் எதுவும் இல்லை",
  };

  String get appTitle => _localizedValues['appTitle']!;
  String get home => _localizedValues['home']!;
  String get search => _localizedValues['search']!;
  String get library => _localizedValues['library']!;
  String get play => _localizedValues['play']!;
  String get pause => _localizedValues['pause']!;
  String get addSong => _localizedValues['addSong']!;
  String get title => _localizedValues['title']!;
  String get artist => _localizedValues['artist']!;
  String get audioUrl => _localizedValues['audioUrl']!;
  String get imageUrl => _localizedValues['imageUrl']!;
  String get add => _localizedValues['add']!;
  String get cancel => _localizedValues['cancel']!;
  String get fillAllFields => _localizedValues['fillAllFields']!;
  String get enterSearchTerm => _localizedValues['enterSearchTerm']!;
  String get noSongsFound => _localizedValues['noSongsFound']!;

  Map<String, String> get _localizedValues {
    switch (locale.languageCode) {
      case 'ta':
        return _taTranslations;
      case 'en':
      default:
        return _enTranslations;
    }
  }
}

class AppLocalizationsDelegate extends LocalizationsDelegate<AppLocalizations> {
  const AppLocalizationsDelegate();

  @override
  bool isSupported(Locale locale) => ['en', 'ta'].contains(locale.languageCode);

  @override
  Future<AppLocalizations> load(Locale locale) => AppLocalizations.load(locale);

  @override
  bool shouldReload(AppLocalizationsDelegate old) => false;
}
