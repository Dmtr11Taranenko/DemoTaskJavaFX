package org.example.demotaskjavafx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Random;

/**
 * Контроллер для приложения DemoTaskJavaFX.
 * Обрабатывает перемещение объектов между списками и вычисление суммы чисел
 * в правом списке.
 */

public class Controller {

    @FXML
    private ListView<String> leftListView;

    @FXML
    private ListView<String> rightListView;

    // Модели данных для левого и правого списков
    private final ObservableList<String> leftList = FXCollections.observableArrayList();
    private final ObservableList<String> rightList = FXCollections.observableArrayList();

    // Формат чисел с запятой
    private final DecimalFormat decimalFormat;

    // В данном конструкторе задается формат чисел с запятой
    public Controller() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');

        decimalFormat = new DecimalFormat("#,##0.00", symbols);
    }


    // Метод инициализации левого списка при загрузке интерфейса.
    // Заполняет список 10-ю случайными дробными числами от 0.00 до 9.99 (включительно).
    @FXML
    public void initialize() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            float num = Math.round(random.nextFloat(0,1) * 1000f) / 100f;
            leftList.add(decimalFormat.format(num));
        }
        leftListView.setItems(leftList);
        rightListView.setItems(rightList);

    }

    // Обработчики кнопок "<" и ">". Перемещают элементы между списками
    public void left(ActionEvent event) {
        String selected = rightListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            rightList.remove(selected);
            leftList.add(selected);
        }
    }

    public void right(ActionEvent event) {
        String selected = leftListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            leftList.remove(selected);
            rightList.add(selected);
        }
    }

    // Обработчик кнопки "Сумма".
    // Вычисляет сумму чисел в правом списке и показывает результат в диалоговом окне
    public void sum(ActionEvent event) {
        float sum = 0f;
        for (String s : rightList) {
            try {
                Number num = decimalFormat.parse(s);
                sum += num.floatValue();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Alert sumWindow = new Alert(Alert.AlertType.INFORMATION);
        sumWindow.setTitle("Сумма");

                                        // Пример не совсем очевидной вещи:
        sumWindow.setHeaderText(null);  // чтобы диалоговое окно было без заголовка,
                                        // заголовок необходимо явно указывать как null

        sumWindow.setContentText("Сумма значений в правой колонке: " +
                decimalFormat.format(sum));
        sumWindow.show();
    }
}
