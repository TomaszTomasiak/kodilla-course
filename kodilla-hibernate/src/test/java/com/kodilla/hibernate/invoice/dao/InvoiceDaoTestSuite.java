package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    ItemDao itemDao;

    @Test
    public void testInvoiceDaoSave() {
    //Given
        Product boat = new Product("boat");
        Product plane = new Product("plane");
        Product truck = new Product("truck");

        Item item1 = new Item(boat, new BigDecimal(21500000),2);
        Item item2 = new Item(plane, new BigDecimal(12500000),1);
        Item item3 = new Item(truck, new BigDecimal(3200000),3);

        Invoice invoice1 = new Invoice("1234/11");
        Invoice invoice2 = new Invoice("4587/03");

        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);
        invoice2.getItems().add(item1);
        invoice2.getItems().add(item3);

        //When
        invoiceDao.saveAll(Arrays.asList(invoice1,invoice2));
        //invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();
        //invoiceDao.save(invoice2);
        int invoice2Id = invoice2.getId();

        //Then
        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertNotEquals(0, invoice2Id);

        //CleanUp
        try {
            invoiceDao.deleteAll();
            itemDao.deleteAll();
            productDao.deleteAll();

        } catch (Exception e) {
            //do nothing
        }
    }
}
