import com.lech.bartlomiej.model.Product;
import com.lech.bartlomiej.model.Receipt;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReceiptTest {

    private Product phoneProd = new Product("100", "Phone", BigDecimal.valueOf(999.99));
    private Product watchProd = new Product("101", "Watch", BigDecimal.valueOf(1000));

    private Receipt receipt;

    @Before
    public void setUp(){
        receipt = new Receipt();
        receipt.addReceiptLine(phoneProd);
        receipt.addReceiptLine(watchProd);
    }

    @Test
    public void should_Add_Receipt_Line(){

        assertEquals(2, receipt.getReceiptLines().size());
    }

    @Test
    public void should_Calculate_Total_Sum(){

        //when
        BigDecimal totalSum = receipt.calculateTotalSum();

        //then
        assertEquals(BigDecimal.valueOf(1999.99), totalSum);
    }


    @Test
    public void should_Add_Total_Sum(){

        //given
        BigDecimal totalSum = receipt.calculateTotalSum();

        //when
        receipt.addTotalSum(totalSum);

        //then
        assertEquals(3, receipt.getReceiptLines().size());

    }

}
