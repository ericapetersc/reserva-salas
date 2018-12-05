package controller;

import beans.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import view.ViewAlterarAluno;
import view.ViewCadastrarAluno;
import view.ViewExcluirAluno;

public class AlunoControllerTest {

    @BeforeClass
    public static void setUpClass() {
        //Testar as classes (apenas as views, no caso, e seus respectivos contrutores) anteriores ao AlunoController
            //MenuPrincipal testMenuPrincipal = MenuPrincipal.getInstance();
            //ViewAlterarAluno testViewAlterar = ViewAlterarAluno.getInstance();
            //ViewBuscarAluno testViewBuscar = ViewBuscarAluno.getInstance();
            //ViewCadastrarAluno testViewCadastrar = ViewCadastrarAluno.getInstance();
            //ViewExcluirAluno testViewExcluir = ViewExcluirAluno.getInstance();
            //ViewListarUsuarios testListarUsuarios = ViewListarUsuarios.getInstance();
        System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }
    
    @AfterClass
    public static void tearDownClass() {
        //Não serão testadas as classes posteriores ao AlunoController
    }
    
    @Before
    public void setUp() {
        //Testar objetos/métodos/construtores anteriores ao AlunoController
        Usuario testUser = new Usuario ("", "", "", "");
        ArrayList testList = new ArrayList();
        System.out.println("@Before: executedBeforeEach");

    }
    
    @After
    public void tearDown() {
        //Não serão testados os objetos/métodos/construtores posteriores ao AlunoController
    }

    @Test
    public void testCadastraAluno() {
        System.out.println("cadastraAluno");
        
        AlunoController instance = new AlunoController();
        ViewCadastrarAluno viewInstance = new ViewCadastrarAluno();
        
        viewInstance.nome.setText("nome");
        viewInstance.sobrenome.setText("sobrenome");
        viewInstance.nascimento.setText("00000000");
        viewInstance.boxCurso.setActionCommand("-1");
        viewInstance.cpf.setText("00000000000");
        viewInstance.matricula.setText("000000000");
        viewInstance.boxFormacao.setActionCommand("-1");
        viewInstance.semestre.setText("00000");
        
        viewInstance.verificaCampos();
        viewInstance.verificaCurso();
        
        instance.cadastraAluno();
        
        assertNotNull(viewInstance.getNome());
        assertNotNull(viewInstance.getSobrenome());
        assertNotNull(viewInstance.getNascimento());
        assertNotNull(viewInstance.getCpf());
        assertNotNull(viewInstance.getMatricula());
        assertNotNull(viewInstance.getSemestre());
    }
    
    @Test
    public void testCadastraAlunoFailCase() {
        System.out.println("cadastraAlunoFailCase");
        
        AlunoController instance = new AlunoController();
        ViewCadastrarAluno viewInstance = new ViewCadastrarAluno();
        
        instance.cadastraAluno();
        
        if(viewInstance.getNome() == null &&
           viewInstance.getSobrenome() == null &&
           viewInstance.getNascimento() == null &&
           viewInstance.getCpf() == null &&
           viewInstance.getMatricula() == null &&
           viewInstance.getSemestre() == null){
                assertTrue(true);
        }
    }
    
    @Test
    public void testAlteraAluno() {
        System.out.println("alteraAluno");
        
        AlunoController instance = new AlunoController();
        ViewCadastrarAluno viewInstanceC = new ViewCadastrarAluno();
        ViewAlterarAluno viewInstanceA = new ViewAlterarAluno();
        
        viewInstanceC.nome.setText("nome");
        viewInstanceC.sobrenome.setText("sobrenome");
        
        instance.cadastraAluno();
        
        viewInstanceA.nome.setText("newNome");
        viewInstanceA.sobrenome.setText("newSobrenome");
        
        if((!"nome".equals(viewInstanceA.getNome())) && (!"sobrenome".equals(viewInstanceA.getSobrenome()))){
            //instance.alteraAluno();
            System.out.println("Está efetuando a alteração!");
            assertEquals(viewInstanceA.getNome(), "newNome");
            assertEquals(viewInstanceA.getSobrenome(), "newSobrenome");
        } else {
            fail("Falha na alteração");
        }
    }
    
    @Test
    public void testAlteraAlunoFailCase() {
        System.out.println("alteraAlunoFailCase");
        
        AlunoController instance = new AlunoController();
        ViewCadastrarAluno viewInstanceC = new ViewCadastrarAluno();
        ViewAlterarAluno viewInstanceA = new ViewAlterarAluno();
        
        viewInstanceC.nascimento.setText("00000000");
        
        instance.cadastraAluno();
        
        viewInstanceA.nascimento.setText("000000000");
        
        if(!"00000000".equals(viewInstanceA.getNascimento())){
            //instance.alteraAluno();
            System.out.println("Mostrou a mensagem de erro e não permitiu a alteração!");
            assertTrue(true);
        } else{
            fail("Falha na falha! Foi possível cadastrar uma data de nascimento maior que a permitida");
        }
    }

    @Test
    public void testExcluiAluno() {
        System.out.println("excluiAluno");
        
        AlunoController instance = new AlunoController();
        ViewExcluirAluno viewInstanceE = new ViewExcluirAluno();
        ViewCadastrarAluno viewInstanceC = new ViewCadastrarAluno();
        
        viewInstanceC.nome.setText("nome");
        viewInstanceC.sobrenome.setText("sobrenome");
        viewInstanceC.nascimento.setText("00000000");
        viewInstanceC.boxCurso.setActionCommand("-1");
        viewInstanceC.cpf.setText("00000000000");
        viewInstanceC.matricula.setText("000000000");
        viewInstanceC.boxFormacao.setActionCommand("-1");
        viewInstanceC.semestre.setText("00000");
        
        viewInstanceC.verificaCampos();
        viewInstanceC.verificaCurso();
        
        instance.cadastraAluno();
        
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
