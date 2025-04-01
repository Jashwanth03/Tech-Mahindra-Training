class Song {
  final String id;
  final String title;
  final String artist;
  final String audioUrl; // Can be a direct audio URL (e.g., from Firestore)
  final String imageUrl; // Can be a Google-hosted image URL

  Song({
    required this.id,
    required this.title,
    required this.artist,
    required this.audioUrl,
    required this.imageUrl,
  });

  factory Song.fromMap(Map<String, dynamic> data, String id) {
    return Song(
      id: id,
      title: data['title'] ?? '',
      artist: data['artist'] ?? '',
      audioUrl: data['audioUrl'] ?? '',
      imageUrl: data['imageUrl'] ?? '',
    );
  }

  Map<String, dynamic> toMap() {
    return {
      'title': title,
      'artist': artist,
      'audioUrl': audioUrl,
      'imageUrl': imageUrl,
    };
  }
}
