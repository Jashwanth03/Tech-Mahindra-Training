import 'package:cloud_firestore/cloud_firestore.dart';
import 'package:music_app/models/song.dart';

class FirebaseService {
  final FirebaseFirestore _firestore = FirebaseFirestore.instance;

  Stream<List<Song>> getSongs() {
    return _firestore.collection('songs').snapshots().map((snapshot) {
      return snapshot.docs.map((doc) {
        return Song.fromMap(doc.data(), doc.id);
      }).toList();
    });
  }

  Future<void> deleteSong(String id) async {
    await _firestore.collection('songs').doc(id).delete();
  }
}
