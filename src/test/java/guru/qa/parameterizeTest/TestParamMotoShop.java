package guru.qa.parameterizeTest;

import guru.qa.page.MotoPage;
import guru.qa.state.BaseState;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;

public class TestParamMotoShop extends BaseState {

    MotoPage moto = new MotoPage();

    @ValueSource(strings = {"Мотоциклы", "Питбайки"})
    @ParameterizedTest(name = "Проверка перехода на разделы каталога {0}")
    void redirectMotoHelmet(String catalogName) {
        moto.menuButton.find(text("Мототехника")).click();
        moto.motoVehicleCategory.findBy(text(catalogName)).click();
        moto.title.shouldHave(text(catalogName));
    }

    @CsvSource(value = {"Экипировка, Мотоэкипировка", "Запчасти, Запчасти для мотоцикла"})
    @ParameterizedTest(name = "Проверка отображения названия в категории {0}")
    void testMoto(String catalog, String catalogTitle) {
        moto.menuButton.find(text(catalog)).click();
        moto.title.shouldHave(text(catalogTitle));
    }

    static Stream<Arguments> catalogList() {
        return Stream.of(
                Arguments.of("Расходники", List.of("Моторезина", "ГСМ", "Фильтры", "Колодки тормозные", "Аккумуляторы", "Свечи", "Цепной привод")),
                Arguments.of("Аксессуары", List.of("Мотоаксессуары", "Подарочные карты", "Товары для отдыха", "Рюкзаки и сумки", "Сувенирная продукция"))
        );
    }

    @MethodSource()
    @ParameterizedTest(name = "Проверка отображения категорий в меню {0}")
    void catalogList(String catalog, List<String> category) {
        moto.menuButton.find(text(catalog)).click();
        moto.motoVehicleCategory.shouldHave(texts(category));
    }
}
