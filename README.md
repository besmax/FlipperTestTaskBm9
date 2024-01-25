# Тестовое задание в Flipper Devices на Android разработчика

Это задание призвано быть максимально близким к реальной задаче, хоть оно и не простое. Точно такая же архитектура и такие же экраны есть в основном приложении и вы сможете использовать его как референс для решения тестового

## Вводные данные

В репозитории находится приложение с тремя вкладками. В каждой вкладке список замков ("Locker") с не привязанными ключами. 

![](docs/task.jpeg)

## Задача

Вам необходимо сделать выбор "замка" для каждого ключа на полный экран. Учтите что:
- Цвет статусбаров/navigation bar должен быть разный и корректно меняться между экранами
- Вкладка живет "своей жизнью", при переключении состояние сохраняется, ключ, добавленный для замка в одной вкладке, не попадает в другую вкладку
- Экран должен быть в Decompose-графе, без использования дополнительных Activity или Fragment
- Приложение должно уметь востанавливаться из фона
- Отдельный экран ключа должен быть в отдельном модуле, оформленном в том же виде как и lockerchoose/bottombar с явным api модулем и impl

Вот gif решения:

![](docs/solution.gif)

Цвет фона на фуллскрине специально сделан другим цветом чтобы подчеркнуть работу изменения цвета статус бара - вам нужно сделать так же

# Полезные материалы

- Документация Decompose: https://arkivanov.github.io/Decompose/
- Репозиторий основного проекта: https://github.com/flipperdevices/Flipper-Android-App
- Документация Anvil: https://github.com/square/anvil
- Dagger Assisted Injection: https://dagger.dev/dev-guide/assisted-injection.html
- Курс по Dagger от Android Broadcast на YouTube: https://www.youtube.com/playlist?list=PL0SwNXKJbuNkYFUda5rlA-odAVyWItRCP