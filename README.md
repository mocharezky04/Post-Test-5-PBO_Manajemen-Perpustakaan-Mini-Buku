# Post Test 5 - PBO
# Manajemen Perpustakaan Mini (Buku dan Majalah)

# Data diri
Nama : Mochammad Rezky Ramadhan 
NIM : 2409116029 Kelas : A 

# Deskripsi singkat
Program ini adalah pengembangan dari Post Test 4.  
Masih bertema **Manajemen Perpustakaan Mini**, namun kini ditambahkan penerapan:
- **Abstraction** = menggunakan abstract class dan interface  
- **Polymorphism** = melalui Overriding & Overloading  
- **Nilai Tambah** = menggabungkan abstract class dan interface  
- **Koneksi Database (JDBC)**  
- **ORM (Object Relational Mapping)**  
- **Data awal berasal dari database, bukan dari kode**
Pengguna dapat:
- Menambahkan item baru (Buku / Majalah)
- Melihat daftar item
- Memperbarui data item
- Menghapus item
- Mencari item berdasarkan judul, penulis, atau tahun terbit
- Menampilkan data dari **database (menu 7)**
- Menampilkan data dari **ORM (menu 8)**
- Menambahkan data langsung **ke database (menu 9)**

---

# Fitur yang diterapkan
- **ArrayList** untuk menyimpan daftar item perpustakaan.
- **Packages** untuk pemisahan kode:  
  - `main` = entry point & menu utama.  
  - `model` = struktur data (`ItemPerpustakaan`, `Buku`, `Majalah`, `CetakInfo`)  
  - `service` = logika CRUD dan fitur tambahan.  
  - `database` = koneksi dan pengambilan data dari MySQL.  
  - `orm` = representasi data database menjadi objek Java.  
- **Constructor** digunakan di semua class model.  
- **Access modifier** atribut `private`, method `public`.  
- **Encapsulation** = semua atribut menggunakan getter & setter.  
- **Inheritance:**
  - `ItemPerpustakaan` sebagai **superclass**
  - `Buku` dan `Majalah` sebagai **subclass**
- **Abstraction:**
  - `abstract class ItemPerpustakaan` = memiliki method abstrak `getInfo()`.
  - `interface CetakInfo` = diimplementasikan oleh `Buku` & `Majalah`.
- **Polymorphism:**
  - `Overriding` = `getInfo()` dan `toString()` di-override pada `Buku` dan `Majalah`.
  - `Overloading` = method `cariItem()` di `PerpustakaanService` memiliki 3 versi:
    - `cariItem(String keyword)`
    - `cariItem(int tahunTerbit)`
    - `cariItem()` (meminta input dari user)
- **Validasi input angka** agar program tidak error saat salah input.
- **Fitur search** untuk mencari berdasarkan judul (atau penulis khusus Buku).
- **Data awal harus diisi lewat database**, tidak diisi lewat kode Java.

---

# Arsitektur MVC
Program ini menerapkan pola **Model-View-Controller (MVC)**:

- **Model**  
  `ItemPerpustakaan`, `Buku`, `Majalah`, `CetakInfo`  
  Menyimpan struktur data Buku dan Majalah, menyediakan constructor, getter, dan setter.  
  `CetakInfo` sebagai interface tambahan untuk method cetakDetail().

- **Controller**  
  `Service.PerpustakaanService`  
  Menangani logika CRUD (Create, Read, Update, Delete), validasi input, dan pencarian.

- **View**  
  `Main.java`  
  Menampilkan menu ke pengguna, menerima input, dan memanggil method dari service.

---

## Struktur Package

<img width="273" height="432" alt="{7D201725-6FF6-4B3A-BEDC-E421A96F9605}" src="https://github.com/user-attachments/assets/ea2af4e5-890d-4866-82fe-c023fa2662e4" />

---

# Alur program
## Menu utama:
    1. Tambah item
    2. Lihat daftar item
    3. Update item
    4. Hapus item
    5. Cari item
    6. Keluar
    7. Tampilkan data dari Database
    8. Lihat data via ORM
    9. Tambah item (Buku dan Majalah) ke Database (ORM)

## Penjelasan Menu
1. **Tambah item**  
   - User pilih jenis (Buku / Majalah).
   - Input data sesuai jenis.
   - Data disimpan di ``ArrayList<ItemPerpustakaan>``.

2. **Lihat daftar item**  
   - Menampilkan semua item.
   - Jika kosong, muncul ``"Belum ada item yang tersimpan."``

3. **Update item**  
   - Pilih nomor item.
   - Jika Buku = update judul, penulis, tahun.
   - Jika Majalah = update judul, tahun, edisi. 

4. **Hapus item**  
   - Pilih nomor item = item dihapus dari list.

5. **Cari item**
   pilih mode pencarian:
     - Judul / Penulis
     - Tahun Terbit

6. **Keluar**  
   - Program berhenti dengan pesan:  
     ```
     Terima kasih sudah menggunakan sistem perpustakaan mini.
     ```
7. **Tampilkan data(Buku) dari Database (JDBC)**  
   - Mengambil dan menampilkan data Buku langsung dari MySQL.

8. **Lihat data via ORM(Majalah)**  
   - Mengambil data Majalah melalui class ORM dan menampilkannya sebagai objek Java.

9. **Tambah item(Buku dan Majalah) ke Database (ORM)**  

---

# Penambahan
```
1. Abstraction:
   - Abstract class: ItemPerpustakaan (method abstrak getInfo()).
   - Interface: CetakInfo (method cetakDetail()).
   - Abstract class dipakai untuk menyatukan struktur dasar item perpustakaan.
   - Interface dipakai agar semua item bisa punya method cetakDetail() walaupun berbeda jenis.

2. Polymorphism:
   - Overriding:
     * getInfo() dan toString() pada Buku & Majalah.
   - Overloading:
     * cariItem(String keyword) = cari berdasarkan judul/penulis.
     * cariItem(int tahunTerbit) = cari berdasarkan tahun.
     * cariItem() = memilih mode pencarian = default, minta input dari user.

3. Kombinasi Abstraction & Interface (Nilai Tambah):
   - Buku dan Majalah mewarisi ItemPerpustakaan (abstract class).
   - Buku dan Majalah juga mengimplementasikan CetakInfo (interface).

4. Database (JDBC):
   - Menggunakan koneksi ke MySQL melalui DatabaseConnection.java
   - Data awal dibaca dari tabel buku & majalah, bukan hardcoded di kode.

5. ORM:
   - Data `Majalah` dan `Buku` dapat diambil dan disimpan langsung ke database.
   - Menu 8 menampilkan data(Majalah) dari ORM.
   - Menu 9 menambah data(Majalah dan Buku) baru ke database melalui ORM.

```

## Penerapan Abstraction
- Abstract class: `ItemPerpustakaan` (method abstrak `getInfo()`).
- Interface: `CetakInfo` (method `cetakDetail()`).
- Buku dan Majalah mewarisi `ItemPerpustakaan` sekaligus mengimplementasikan `CetakInfo`.

## Penerapan Polymorphism
- Overriding:
  * `getInfo()` di-override di `Buku` dan `Majalah`.
  * `toString()` di-override di `Buku` dan `Majalah`.
- Overloading:
  * `cariItem(String keyword)`
  * `cariItem(int tahunTerbit)`
  * `cariItem()` (meminta input dari user).

- Contoh penerapan **Abstraction (class/interface yang digunakan)**:

<img width="1072" height="809" alt="{1BE5777D-6400-48F0-9642-8747BA5BF2B0}" src="https://github.com/user-attachments/assets/f060e8d1-a500-4105-a50d-0a5e57b97b60" />
<img width="1069" height="845" alt="{51E6EB86-D0E8-4F64-B8C2-AE3EAAAD1418}" src="https://github.com/user-attachments/assets/7b72ebc9-cfa7-4aea-9c3e-3d4e28065a42" />
<img width="303" height="111" alt="{17FD6C8E-5109-41A7-BC00-6A389622264C}" src="https://github.com/user-attachments/assets/78d76532-fbc6-419b-9238-4a4846ee6de5" />


- Contoh penerapan **Polymorphism (Overloading & Overriding)**:

<img width="1071" height="712" alt="{DB1FF1B1-091B-4571-A54F-BA7F453D378F}" src="https://github.com/user-attachments/assets/45f30a58-5121-4483-8a0d-dc05d103bc04" />
<img width="1059" height="763" alt="{CE7E7607-D655-4CD3-A664-7CC8F4A0A593}" src="https://github.com/user-attachments/assets/a6429fcc-6869-4037-a33b-cd90dbc6f824" />



## Contoh output:

<img width="362" height="238" alt="{D7107B4B-4781-4395-936A-DE339840B968}" src="https://github.com/user-attachments/assets/f1b4038d-1fb9-4cc4-9731-9395e3c3aeb7" />


## Contoh Output
### 1. Tambah item (Buku dan Majalah)

<img width="290" height="280" alt="{A3011CCB-7780-4B7A-8760-DA1ED68F39BC}" src="https://github.com/user-attachments/assets/2970ab18-3960-4676-ad7d-0c5d73fc0336" />
<img width="302" height="273" alt="{075D002A-7A95-4A74-B560-EF3DFEAA6CCE}" src="https://github.com/user-attachments/assets/24875eaf-5898-4ba6-8cc3-41edb99354d2" />

### 2. Lihat item

<img width="352" height="218" alt="{E00CF2BE-E6E6-4B87-AEB2-8A88C1534C8D}" src="https://github.com/user-attachments/assets/6ffdeab7-d49a-4fd2-a30f-dcc56fcd6a94" />

### 3. Update item

<img width="354" height="294" alt="{34463E78-5E04-4862-92CC-13A246ED7969}" src="https://github.com/user-attachments/assets/f670fb83-bda5-46f1-ae7a-0c5fd317958c" />

### 4. Hapus item

<img width="384" height="245" alt="{AC6FDB3B-D08E-494A-BF6A-8D5E51A52A81}" src="https://github.com/user-attachments/assets/d742502e-f66c-4950-82ad-8ef99b7ef07a" />
<img width="361" height="191" alt="{71221A60-B5B2-4FBE-A06F-B505B84D68B6}" src="https://github.com/user-attachments/assets/ebc06962-3f01-4c48-b969-2424415b88ea" />

### 5. Cari item

<img width="359" height="226" alt="{22E1132F-FEA1-4A0D-AA07-0490FFF16E6E}" src="https://github.com/user-attachments/assets/3ddc5d6d-f749-4b76-8ace-35abb181798d" />
<img width="392" height="208" alt="{5C429DCA-E50E-4A11-A82E-CED437DF25E6}" src="https://github.com/user-attachments/assets/c84c5e6e-15e8-4a03-bdce-bb1e547e0e46" />
<img width="378" height="228" alt="{C366F8DA-3C4E-45FF-B7A9-1384BB41302C}" src="https://github.com/user-attachments/assets/0e2d6893-e148-4e4e-8638-20f8b78bc3d7" />

### 7. Tampilkan data(Buku) dari Database (JDBC)

<img width="347" height="310" alt="{83C9A40C-0938-4593-BD7A-67A04465DA2B}" src="https://github.com/user-attachments/assets/6908469b-4881-44c2-b4c8-4eb4dfa3e8f0" />

### 8. Lihat data via ORM (Majalah)

<img width="365" height="262" alt="{1D56500D-6A19-4EFB-B846-D4339FDFA859}" src="https://github.com/user-attachments/assets/21047040-329e-4192-9c7d-f727954bdf1c" />

### 9. Tambah item (Buku dan Majalah) ke Database (ORM)

<img width="377" height="655" alt="{D3AE4333-4D1F-4A37-A8C9-9DB8FBE324D5}" src="https://github.com/user-attachments/assets/01311e42-883a-49fb-a611-44f13f250d77" />
