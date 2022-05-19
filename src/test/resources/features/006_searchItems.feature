#language: ru
@006
Функционал: Поиск товара

  @006_1 @all_cases
  Сценарий: Поиск товара по существующему названию
    Когда пользователь вводит в поиске "Снуд-хомут Regarzo"
    Тогда товар с названием "Снуд-хомут Regarzo" отображается в результах поиска

  @006_2 @all_cases
  Сценарий: Поиск товара по несуществующему названию
    Когда пользователь вводит в поиске "Сну-хому Regarz"
    Тогда ничего не найдено