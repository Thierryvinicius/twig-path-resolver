# Twig Path Resolver

![JetBrains Plugin](https://img.shields.io/badge/JetBrains-PhpStorm-blue?logo=phpstorm)

**Twig Path Resolver** is a PhpStorm extension that streamlines navigation between PHP controllers and their corresponding Twig/HTML view files. With this plugin, you can quickly jump from a `setView("...")` call in your PHP code directly to the related `.html` file in your `views/` directory using `Ctrl+Click`.

---

## Features
- **Fast navigation:** Instantly open the target view file by Ctrl+Clicking the view path in your PHP code.
- **Seamless integration:** Works out-of-the-box with standard `setView("...")` patterns.
- **Improved productivity:** Reduces time spent searching for view files in large projects.

## Installation
1. Build the plugin using `./gradlew buildPlugin` (the `.zip` will be in `build/distributions/`).
2. In PhpStorm, go to **Settings > Plugins > ⚙️ > Install Plugin from Disk...**
3. Select the generated `.zip` file and restart PhpStorm.

## Usage
- In your PHP controller, use `setView("view-name")` as usual.
- Hold `Ctrl` and click on the view name string.
- The plugin will open the corresponding `views/view-name.html` file automatically.

### Example
```php
// PHP Controller
$this->setView("home/index");
```
Ctrl+Clicking on `"home/index"` will open `views/home/index.html`.

## Requirements
- PhpStorm 2023.3 or later
- PHP and Twig support enabled in your project

## Contributing
Contributions are welcome! To contribute:
1. Fork this repository
2. Create a feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to your branch (`git push origin feature/your-feature`)
5. Open a Pull Request

## License
This project is licensed under the MIT License.

---
Developed by Thierry 