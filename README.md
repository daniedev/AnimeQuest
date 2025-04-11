# AnimeQuest 

A basic anime listing app built using Jetpack Compose and the Jikan API. You can browse popular anime, view details, and watch trailers (if available).


<img src="https://github.com/user-attachments/assets/f7f97a99-8e3a-4d87-a2bf-80b15cf800a3" width=200 height=450>
<img src="https://github.com/user-attachments/assets/c227719a-6641-4c15-aa81-6599f6aa9609" width=200 height=450>
<img src="https://github.com/user-attachments/assets/8bc21896-be12-4fb7-a942-813efa0dd60d" width=200 height=450>
<img src="https://github.com/user-attachments/assets/f2df2386-4e1c-4456-950c-196697416d29" width=200 height=450>

---

## Assumptions
- Trailer videos are expected to be from YouTube.
- No local storage or caching is included.
- The app is designed for online use only (needs internet access).

---

## Features

- Clean architecture with `data`, `domain`, and `app` modules
- Hilt for dependency injection
- Uses Jetpack Compose for UI and state management

---

## Known Issues / Limitations

- Only the first page of top anime is loaded (no pagination yet)
- No proper error messages or retry options

---

## To Do

- Add search and pagination
- Show error states and loading indicators
- Add offline support
- Write unit and UI tests

---
