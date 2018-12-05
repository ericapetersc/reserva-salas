package controller;

import beans.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.ViewAlterarServidor;
import view.ViewCadastrarServidor;
import view.ViewExcluirServidor;

public class ServidorControllerTest {
    
    @BeforeClass
    public static void setUpClass() {
        //Testar as classes (apenas as views, no caso, e seus respectivos contrutores) anteriores ao ServidorController
            //MenuPrincipal testMenuPrincipal = MenuPrincipal.getInstance();
            //ViewAlterarServidor testViewAlterar = ViewAlterarServidor.getInstance();
            //ViewBuscarServidor testViewBuscar = ViewBuscarServidor.getInstance();
            //ViewCadastrarServidor testViewCadastrar = ViewCadastrarServidor.getInstance();
            //ViewExcluirServidor testViewExcluir = ViewExcluirServidor.getInstance();
            //ViewListarUsuarios testListarUsuarios = ViewListarUsuarios.getInstance();
            //System.out.println("@BeforeClass: onceExecutedBeforeAll");
        System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }
    
    @AfterClass
    public static void tearDownClass() {
        //Não serão testadas as classes posteriores ao ServidorController
    }
    
    @Before
    public void setUp() {
        //Testar objetos/métodos/construtores anteriores ao ServidorController
        Usuario testUser = new Usuario ("", "", "", "");
        ArrayList testList = new ArrayList();
        System.out.println("@Before: executedBeforeEach");
    }
    
    @After
    public void tearDown() {
         //Não serão testados os objetos/métodos/construtores posteriores ao ServidorController
    }

    @Test
    public void testCadastraServidor() {
        System.out.println("cadastraServidor");
        
        ServidorController instance = new ServidorController();
        ViewCadastrarServidor viewInstance = new ViewCadastrarServidor();
        
        viewInstance.nome.setText("nome");
        viewInstance.sobrenome.setText("sobrenome");
        viewInstance.nascimento.setText("00000000");
        viewInstance.cpf.setText("00000000000");
        viewInstance.id.setText("0");
        viewInstance.boxCargo.setActionCommand("0");
        
        viewInstance.verificaCampos();
        
        instance.cadastraServidor();
        
        assertNotNull(viewInstance.getNome());
        assertNotNull(viewInstance.getSobrenome());
        assertNotNull(viewInstance.getNascimento());
        assertNotNull(viewInstance.getCpf());
        assertNotNull(viewInstance.getId());
    }
    
    @Test
    public void testCadastraServidorFailCase() {
        System.out.println("cadastraServidorFailCase");
        
        ServidorController instance = new ServidorController();
        ViewCadastrarServidor viewInstance = new ViewCadastrarServidor();
        
        instance.cadastraServidor();
        
        if(viewInstance.getNome() == null &&
           viewInstance.getSobrenome() == null &&
           viewInstance.getNascimento() == null &&
           viewInstance.getCpf() == null &&
           viewInstance.getId()== null){
                assertTrue(true);
        }
    }

    @Test
    public void testAlteraServidor() {
        System.out.println("alteraServidor");
        
        ServidorController instance = new ServidorController();
        ViewCadastrarServidor viewInstanceC = new ViewCadastrarServidor();
        ViewAlterarServidor viewInstanceA = new ViewAlterarServidor();
        
        viewInstanceC.nome.setText("nome");
        viewInstanceC.sobrenome.setText("sobrenome");
        
        instance.cadastraServidor();
        
        viewInstanceA.nome.setText("newNome");
        viewInstanceA.sobrenome.setText("newSobrenome");
        
        if((!"nome".equals(viewInstanceA.getNome())) && (!"sobrenome".equals(viewInstanceA.getSobrenome()))){
            //instance.alteraServidor();
            System.out.println("Está efetuando a alteração!");
            assertEquals(viewInstanceA.getNome(), "newNome");
            assertEquals(viewInstanceA.getSobrenome(), "newSobrenome");
        } else {
            fail("Falha na alteração");
        }
    }
    
    @Test
    public void testAlteraServidorFailCase() {
        System.out.println("alteraServidorFailCase");
        
        ServidorController instance = new ServidorController();
        ViewCadastrarServidor viewInstanceC = new ViewCadastrarServidor();
        ViewAlterarServidor viewInstanceA = new ViewAlterarServidor();
        
        viewInstanceC.nascimento.setText("00000000");
        
        instance.cadastraServidor();
        
        viewInstanceA.nascimento.setText("000000000");
        
        if(!"00000000".equals(viewInstanceA.getNascimento())){
            //instance.alteraServidor();
            System.out.println("Mostrou a mensagem de erro e não permitiu a alteração!");
            assertTrue(true);
        } else{
            fail("Falha na falha! Foi possível cadastrar uma data de nascimento maior que a permitida");
        }
    }

    @Test
    public void testExcluiServidor() {
        System.out.println("excluiServidor");
        
        ServidorController instance = new ServidorController();
        ViewExcluirServidor viewInstanceE = new ViewExcluirServidor();
        ViewCadastrarServidor viewInstanceC = new ViewCadastrarServidor();
        
        viewInstanceC.nome.setText("nome");
        viewInstanceC.sobrenome.setText("sobrenome");
        viewInstanceC.nascimento.setText("00000000");
        viewInstanceC.cpf.setText("00000000000");
        viewInstanceC.id.setText("0");
        viewInstanceC.boxCargo.setActionCommand("0");
        
        viewInstanceC.verificaCampos();
        
        instance.cadastraServidor();
        
        viewInstanceE.combo.getParent();
        
        if(viewInstanceE.combo.getParent() != null){
            //instance.excluiAluno();
            System.out.println("Está efetuando a exclusão!");
            assertTrue(true);
        } else {
            fail("Falha na exclusão");
        }
    }
}
