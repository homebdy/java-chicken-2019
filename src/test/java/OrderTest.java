import domain.Menu;
import domain.MenuRepository;
import domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {

    @DisplayName("메뉴와 수량을 입력해 주문한다.")
    @Test
    void addMenu() {
        Order order = new Order();
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 3;

        order.addMenu(menu, quantity);

        assertThat(order.chickenNumber()).isEqualTo(3);
    }

    @DisplayName("주문이 없는 경우 false를 반환한다.")
    @Test
    void hasOrder() {
        Order order = new Order();

        assertThat(order.hasOrder()).isFalse();
    }

    @DisplayName("결제가 완료된 경우 초기화 한다.")
    @Test
    void payment() {
        Order order = new Order();
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 3;
        order.addMenu(menu, quantity);

        order.payment();

        assertThat(order.hasOrder()).isFalse();
    }

    @DisplayName("현재 주문된 메뉴들의 총 금액을 반환한다.")
    @Test
    void getTotalPrice() {
        Order order = new Order();
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 3;
        order.addMenu(menu, quantity);

        int price = order.totalPrice();

        assertThat(price).isEqualTo(48000);
    }

    @DisplayName("같은 메뉴를 100개 이상 주문할 경우 예외 발생")
    @Test
    void orderException() {
        Order order = new Order();
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 100;

        assertThatThrownBy(() -> order.addMenu(menu, quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }
}