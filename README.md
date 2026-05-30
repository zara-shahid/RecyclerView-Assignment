# RecycleView — Android Food List Demo

A simple Android application demonstrating the use of `RecyclerView` with a custom adapter and model class to display a horizontal scrolling list of food items with images and names.

---


## Features

- Horizontal `RecyclerView` displaying food item cards
- Custom `FoodAdapter` binding image and name to each item view
- `FoodModel` POJO with full getter/setter support
- `CardView`-based item layout (`sample_recyclerview.xml`)
- Edge-to-edge display with system bar inset handling via `ViewCompat`
- Single activity architecture

---

## Project Structure

```
RecycleView/
├── app/
│   └── src/
│       ├── androidTest/java/com/tams/recycleview/
│       │   └── ExampleInstrumentedTest.java     # Instrumented test (package name check)
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/com/tams/recycleview/
│           │   ├── MainActivity.java             # Entry point; sets up RecyclerView
│           │   ├── Adapters/
│           │   │   └── FoodAdapter.java          # RecyclerView.Adapter implementation
│           │   └── Models/
│           │       └── FoodModel.java            # Data model (image resource ID + name)
│           └── res/
│               ├── drawable/
│               │   ├── image1                    # Cheese Burger image
│               │   └── image2                    # Pizza image
│               └── layout/
│                   ├── activity_main.xml         # Root layout with RecyclerView
│                   └── sample_recyclerview.xml   # Individual item layout
├── build.gradle.kts
├── settings.gradle.kts
└── gradle/
    └── libs.versions.toml
```

---

## How It Works

### FoodModel
A plain Java data class holding an image resource ID (`int`) and a display name (`String`), with a constructor and full getters/setters.

### FoodAdapter
Extends `RecyclerView.Adapter`. Key responsibilities:
- `onCreateViewHolder` — inflates `sample_recyclerview.xml` into a `viewHolder`
- `onBindViewHolder` — sets the `ImageView` and `TextView` for each item using `FoodModel` getters
- `getItemCount` — returns the size of the data list

### MainActivity
- Builds an `ArrayList<FoodModel>` with sample food entries
- Configures a horizontal `LinearLayoutManager`
- Attaches `FoodAdapter` to the `RecyclerView`
- Applies window insets for edge-to-edge display

```java
arrlist.add(new FoodModel(R.drawable.image1, "Cheese Burger"));
arrlist.add(new FoodModel(R.drawable.image2, "Pizza"));

LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
myRecyclerView.setLayoutManager(layoutManager);
myRecyclerView.setAdapter(new FoodAdapter(arrlist, this));
```

---

## Tech Stack

| Component | Version |
|---|---|
| Android Gradle Plugin | 9.0.1 |
| Gradle | 9.2.1 |
| Java | 21 |
| `androidx.recyclerview` | 1.4.0 |
| `androidx.cardview` | 1.0.0 |
| `androidx.appcompat` | 1.7.1 |
| `androidx.activity` | 1.13.0 |
| `androidx.constraintlayout` | 2.2.1 |
| Material Components | 1.14.0 |

---

## Getting Started

### Prerequisites

- Android Studio (latest stable recommended)
- JDK 21
- Android device or emulator

### Setup

1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd RecycleView
   ```

2. Open the project in Android Studio.

3. Add your food images to `app/src/main/res/drawable/`:
   - `image1` — Cheese Burger
   - `image2` — Pizza

4. Sync Gradle and run on an emulator or physical device.

---

## Running Tests

**Instrumented test** (requires a connected device or emulator):
```bash
./gradlew connectedAndroidTest
```
The included `ExampleInstrumentedTest` verifies the app package name is `com.tams.recycleview`.

---

## Extending the App

- **Add more items** — append new `FoodModel` entries to `arrlist` in `MainActivity`
- **Change orientation** — switch `LinearLayoutManager.HORIZONTAL` to `VERTICAL`
- **Grid layout** — replace `LinearLayoutManager` with `GridLayoutManager`
- **Click listeners** — add an `OnClickListener` inside `FoodAdapter.viewHolder`
- **Dynamic data** — replace the static list with a network or Room database source

---

## License

This project is intended for educational purposes.
