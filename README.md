# 📱 ProfilApp – Jetpack Compose

<div style="display:flex; gap:12px; justify-content:center; align-items:flex-start; flex-wrap:wrap;">
  <img src="URL_IMAGE_1" alt="screenshot1" style="max-width:32%; height:auto; border-radius:8px;" />
  <img src="URL_IMAGE_2" alt="screenshot2" style="max-width:32%; height:auto; border-radius:8px;" />
  <img src="URL_IMAGE_3" alt="screenshot3" style="max-width:32%; height:auto; border-radius:8px;" />
</div>

Sebuah koleksi aplikasi sederhana yang dibangun menggunakan Jetpack Compose untuk melatih dan mendemonstrasikan penggunaan state dalam berbagai skenario. Proyek ini berisi tiga aplikasi mini:

1. Counter App: Aplikasi penghitung angka plus-minus.
2. Color Toggle App: Kotak yang warnanya dapat diubah dengan sekali klik.
3. Interactive Profile App: Kartu profil mahasiswa dengan tombol Follow/Unfollow.

Proyek ini bertujuan untuk memahami bagaimana remember { mutableStateOf() } digunakan untuk mengelola data numerik (Int) dan boolean (Boolean) untuk menciptakan UI yang reaktif.

---

## 🔎 Penjelasan Singkat Kode

- **MainActivity**  
  - Berfungsi sebagai "saklar" manual untuk menampilkan salah satu dari tiga aplikasi latihan dengan mengaktifkan satu Composable pada setContent.
  ```kotlin
    setContent {
        // CounterScreen()
        // ColorToggleScreen()
        ProfilApp()
    }
    ```

- **CounterScreen.kt (Composable)**  
  - Tujuan: Membuat aplikasi penghitung sederhana.
  - State: Menggunakan var count by remember `{ mutableStateOf(0) }` untuk menyimpan nilai angka (Int).
  - Logika: Terdapat dua tombol. Satu untuk menambah nilai count, dan satu lagi untuk mengurangi nilai count dengan validasi agar angka tidak bisa kurang dari nol. Setiap perubahan pada count akan langsung memperbarui teks angka di layar.


- **ColorToggleScreen.kt (Composable)**  
  - Tujuan: Membuat sebuah Box yang warnanya bisa berubah saat disentuh.
  - State: Menggunakan var isRed by remember `{ mutableStateOf(false) }` untuk menyimpan kondisi warna (Boolean).
  - Logika: Modifier.background() pada Box akan menampilkan warna Merah jika isRed bernilai true, dan Hijau jika false. Modifier.clickable bertugas membalik nilai isRed setiap kali Box diklik, sehingga warnanya ikut berubah secara reaktif.


- **ColorToggleScreen.kt (Composable)**
  - Tujuan: Menampilkan kartu profil interaktif.
  - State: Menggunakan var isFollowed by remember `{ mutableStateOf(false) }` untuk melacak status "follow" (Boolean).
  - Logika: Status isFollowed mengontrol dua hal sekaligus:
    1. Teks di dalam OutlinedButton ("follow" atau "unfollow").
  2. Teks indikator di bawah tombol ("Anda Mengikuti Akun Ini" atau "Anda Belum Mengikuti Aku Ini"). Saat tombol ditekan, state berubah dan kedua elemen UI tersebut otomatis diperbarui.


---

## ✨ Keuntungan Jetpack Compose dibandingkan XML Layout

1. **UI & Logika dalam Satu Tempat**  
   - Compose: UI dan logika didefinisikan di tempat yang sama (file .kt). Variabel state (misalnya isFollowed) bisa langsung digunakan oleh Button dan Text, sehingga alur kode jelas dan ringkas.  
   - XML: Membutuhkan dua file terpisah (.xml untuk layout dan .kt untuk logika). Kita harus menghubungkannya menggunakan findViewById atau View Binding, lalu menambahkan event listener secara manual di file Kotlin.

2. **Pembaruan UI: Otomatis vs Manual**  
   - Compose: Kekuatan utamanya ada di sifat reaktif. Kita hanya perlu mendeklarasikan UI berdasarkan state, misalnya:
   ```kotlin
   Text(if (isFollowed) "Unfollow" else "Follow")

    ```
  - XML: Menggunakan pendekatan imperatif. Kita harus memperbarui UI secara manual di dalam onClickListener.
    ```kotlin
    isFollowed = !isFollowed
      if (isFollowed) {
        binding.followButton.text = "Unfollow"
        binding.statusText.text = "Anda Mengikuti Akun Ini"
      } else {
        binding.followButton.text = "Follow"
        binding.statusText.text = "Anda Belum Mengikuti Akun Ini"
      }
    ```

3. **Kode Lebih Ringkas & Mudah Dibaca**
  - Compose: Tidak memerlukan View Binding atau kode pembaruan UI manual. Hasilnya, kode lebih singkat, lebih mudah dibaca, dan langsung menggambarkan tampilan yang ingin dibuat.
  - XML: Cenderung menghasilkan boilerplate code lebih banyak, terutama untuk setup awal dan setiap interaksi yang mengubah tampilan.


---

## 📌 Kesimpulan
Proyek ini secara efektif mendemonstrasikan kekuatan dan fleksibilitas manajemen state di Jetpack Compose. Melalui tiga aplikasi sederhana—Counter, Color Toggle, dan Profil Interaktif—terlihat jelas bagaimana remember { mutableStateOf() } menjadi fondasi untuk menciptakan UI yang dinamis dan reaktif. Kita belajar bahwa state dapat dengan mudah mengelola berbagai tipe data, mulai dari angka (Int) untuk kalkulasi, kondisi visual (Boolean) untuk mengubah warna, hingga logika ganda yang memengaruhi beberapa elemen UI sekaligus. Semua interaksi ini dicapai dengan kode yang jauh lebih ringkas dan intuitif, menghilangkan kebutuhan untuk manipulasi View secara manual yang kompleks seperti pada sistem XML tradisional.
