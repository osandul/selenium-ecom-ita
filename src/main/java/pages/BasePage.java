package pages;

import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
public class BasePage extends AbstractBasePage {
    @Getter
    @Accessors(fluent = true)
    protected HeaderComponent headerComponent = new HeaderComponent();

}
