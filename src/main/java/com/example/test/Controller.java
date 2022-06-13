package com.example.test;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

    @FXML
    private ToggleGroup answers;

    @FXML
    private Text questionText;

    @FXML
    private RadioButton radButt_1;

    @FXML
    private RadioButton radButt_2;

    @FXML
    private RadioButton radButt_3;

    @FXML
    private RadioButton radButt_4;

    @FXML
    private Button answerButt;

    @FXML
    private Button HistoryButt;

    @FXML
    private Button SettingsButt;

    @FXML
    private Button SignInButt;

    @FXML
    private Button TestButt;

    //Массив класса Questions
    private Questions[] questions = new Questions[] {
            new Questions("2+2 = ?", new String[] {"3", "5", "1", "4"}),
            new Questions("3+3 = ?", new String[] {"2", "4", "7", "6"}),
            new Questions("4+4 = ?", new String[] {"4", "7", "9", "8"})
    };
    //Счетчик текущего номера вопроса, счетчик количества правильных ответов
    private int currentQuestion = 0, correctAnswers;
    //Строка для хранения корретного ответа текущего вопроса
    private String currentCorrectAnswer;

    @FXML
    void initialize() {
        SignInButt.setOnAction(event -> {
            System.out.println("Вы пока не можете пережить концовку");
        });
        //Берем корреткный ответ для текущего вопроса
        currentCorrectAnswer = questions[currentQuestion].correctAnswer();
        //Отслеживаем нажатие на кнопку "Ответить"
        answerButt.setOnAction(event -> {
            //Получаем выбранную пользователем кнопку
            RadioButton selectedRadioButton = (RadioButton) answers.getSelectedToggle();
            //Код выполнится только если ответ выбран
            if (selectedRadioButton != null) {
                // Получаем текст ответа
                String toogleGroupValue = selectedRadioButton.getText();
                //Сверяем с правильным
                if (toogleGroupValue.equals(currentCorrectAnswer)) {
                    //Выводим информацию и увеличиваем кол-во верных ответов
                    System.out.println("Верный ответ");
                    correctAnswers++;
                } else
                    System.out.println("Неверный ответ");

                //Если сейчас был последний вопрос то скрываем все поля
                if (currentQuestion + 1 == questions.length) {
                    radButt_1.setVisible(false);
                    radButt_2.setVisible(false);
                    radButt_3.setVisible(false);
                    radButt_4.setVisible(false);
                    answerButt.setVisible(false);

                    //Показываем текст в конце
                    questionText.setText("Ваш результат: " + correctAnswers + "/" + questions.length);
                } else { //Если есть ещё вопросы, то увеличиваем номер текущего
                    currentQuestion++;
                    currentCorrectAnswer = questions[currentQuestion].correctAnswer();
                    questionText.setText(questions[currentQuestion].getQuestion()); //Получаем текст вопроса
                    String[] answers = questions[currentQuestion].getAnswers(); //Получаем массив ответов
                    List<String> intList = Arrays.asList(answers); //Преобразуем в список (так удобнее сортировать элементы)
                    Collections.shuffle(intList); //Мешаем в случайном порядке

                    //Подставляем ответы в кнопки
                    radButt_1.setText(intList.get(0));
                    radButt_2.setText(intList.get(1));
                    radButt_3.setText(intList.get(2));
                    radButt_4.setText(intList.get(3));

                    //Снимаем выделение, указанное пользователем ранее
                    selectedRadioButton.setSelected(false);
                }
            }
        });
    }
}
