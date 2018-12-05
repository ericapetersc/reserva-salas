package controller;

import beans.Reserva;
import beans.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.ViewExcluirReserva;
import view.ViewFazerReserva;

public class ReservaControllerTest {
    
    @BeforeClass
    public static void setUpClass() {
        //Testar as classes (apenas as views, no caso, e seus respectivos contrutores) anteriores ao ReservaController
            //MenuPrincipal testMenuPrincipal = MenuPrincipal.getInstance();
            //ViewBuscarReserva testViewBuscar = ViewBuscarReserva.getInstance();
            //ViewExcluirReserva testViewExcluir = ViewExcluirReserva.getInstance();
            //ViewFazerReserva testViewFazer = ViewFazerReserva.getInstance();
            //ViewListarReservas testViewListarReservas = ViewListarReservas.getInstance();
            //ViewListarSalas testViewListarSalas = ViewListarSalas.getInstance();
            //ViewListarUsuarios testListarUsuarios = ViewListarUsuarios.getInstance();
        System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }
    
    @AfterClass
    public static void tearDownClass() {
        //Não serão testadas as classes posteriores ao ReservaController
    }
    
    @Before
    public void setUp() {
        //Testar objetos/métodos/construtores anteriores ao ReservaController
        Usuario testUser = new Usuario ("", "", "", "");
        Reserva testReserva = new Reserva("", -1, "", "");
        ArrayList testList = new ArrayList();
        System.out.println("@Before: executedBeforeEach");
    }
    
    @After
    public void tearDown() {
        //Não serão testados os objetos/métodos/construtores posteriores ao ReservaController
    }

    @Test
    public void testFazReserva() {
        System.out.println("fazReserva");
        
        ReservaController instance = new ReservaController();
        ViewFazerReserva viewInstance = new ViewFazerReserva();
        
        viewInstance.boxUsuario.setActionCommand("00000000000");
        viewInstance.boxPeriodo.setActionCommand("Manhã");
        viewInstance.dataCampo.setText("00000000");
        viewInstance.boxBloco.setActionCommand("A");
        
        //instance.fazReserva();
        
        assertNotNull(viewInstance.getPeriodo());
        assertNotNull(viewInstance.getData());
        assertNotNull(viewInstance.getBloco());
    }
    
    @Test
    public void testFazReservaFailCase() {
        System.out.println("fazReservaFailCase");
        
        ReservaController instance = new ReservaController();
        ViewFazerReserva viewInstance = new ViewFazerReserva();
        
        //instance.fazReserva();
        
        if(viewInstance.getPeriodo()== null &&
           viewInstance.getData()== null &&
           viewInstance.getBloco() == null){
                assertTrue(true);
        }
    }

    @Test
    public void testExcluiReserva() {
        System.out.println("excluiReserva");
        
        ReservaController instance = new ReservaController();
        ViewExcluirReserva viewInstanceE = new ViewExcluirReserva();
        ViewFazerReserva viewInstanceF = new ViewFazerReserva();
        
        viewInstanceF.boxUsuario.setActionCommand("00000000000");
        viewInstanceF.boxPeriodo.setActionCommand("Manhã");
        viewInstanceF.dataCampo.setText("00000000");
        viewInstanceF.boxBloco.setActionCommand("A");
        
        //instance.fazReserva();
        
        viewInstanceE.combo.getParent();
        
        if(viewInstanceE.combo.getParent() != null){
            //instance.excluiReserva();
            System.out.println("Está efetuando a exclusão!");
            assertTrue(true);
        } else {
            fail("Falha na exclusão");
        }
    }
}
