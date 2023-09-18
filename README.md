
# Gallery Handler Android App

Gallery Handler is an Android application that allows users to browse and view pictures and videos from their device's gallery. It leverages the Navigation component, ViewPager2 with TabLayout, and follows the MVVM architecture pattern. This repository provides the source code for the Gallery Handler app.

## Features

- Browse and view pictures and videos from your device's gallery.
- Organize media into sections: Picture Gallery and Video Gallery.
- Swipe between sections using ViewPager2 with TabLayout.
- Follows the MVVM (Model-View-ViewModel) architecture for clean and maintainable code.
- Unit tests for ViewModels to ensure reliable and bug-free functionality.

## Screenshots

![378252867_323385893533267_8504968097402371370_n](https://github.com/AbdelrhmanHosnyAboElmag/GalleryHandler/assets/102666930/95afed60-3cff-4f0b-a635-4d448cba9df3)
![378265629_2529603597196037_6507543647218911484_n](https://github.com/AbdelrhmanHosnyAboElmag/GalleryHandler/assets/102666930/7946fcbe-a0a7-4392-be86-4531c36aef85)

## Getting Started

These instructions will help you set up and run the Gallery Handler app on your local development environment.

### Prerequisites

- Android Studio (or your preferred Android development IDE)
- Android SDK
- Git


## Usage

- Upon launching the app, grant necessary permissions to access your device's gallery.
- Explore the Picture Gallery and Video Gallery sections by swiping between them.
- Tap on media items to view them in a full-screen mode.

## Architecture

The Gallery Handler app follows the MVVM (Model-View-ViewModel) architecture:

- **Model**: Contains data models and repositories for fetching data.
- **ViewModel**: Manages UI-related data and business logic, provides data to the UI.
- **View**: Defines the user interface, including activities and fragments.

## Unit Tests

Unit tests for the ViewModels are located in the `app/src/test` directory. These tests ensure that the ViewModel classes behave as expected.

To run unit tests, right-click on a test file in Android Studio and select "Run."

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them with descriptive commit messages.
4. Push your changes to your fork.
5. Create a pull request to the `main` branch of this repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Thanks to the open-source community for providing valuable resources and libraries.

## Contact

If you have any questions or suggestions, feel free to contact the project maintainers:

- Abdelrhman Hosny - abdelrhmanhosnydev@gmail.com
