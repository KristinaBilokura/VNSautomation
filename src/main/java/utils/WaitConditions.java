package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.function.Function;

public class WaitConditions {

    public enum PageElement {

        CLICKABLE(ExpectedConditions::elementToBeClickable),
        VISIBLE(ExpectedConditions::visibilityOfElementLocated),
        PRESENT(ExpectedConditions::presenceOfElementLocated);

        private Function<By, ExpectedCondition<WebElement>> type;

        PageElement(Function<By, ExpectedCondition<WebElement>> type) {
            this.type = type;
        }

        public Function<By, ExpectedCondition<WebElement>> getType() {
            return this.type;
        }
    }

    public enum PageElements {

        PRESENT(ExpectedConditions::presenceOfAllElementsLocatedBy),
        VISIBLE_S(ExpectedConditions::visibilityOfAllElementsLocatedBy);

        private Function<By, ExpectedCondition<List<org.openqa.selenium.WebElement>>> type;

        PageElements(Function<By, ExpectedCondition<List<WebElement>>> type) {
            this.type = type;
        }

        public Function<By, ExpectedCondition<List<WebElement>>> getType() {
            return this.type;
        }

    }

}
