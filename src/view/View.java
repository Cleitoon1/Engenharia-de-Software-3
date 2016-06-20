package view;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import org.json.JSONException;

import model.EducacaoMOD;
import model.Model;

public class View { 

	private static JPanel Painel = new JPanel();
    static JFrame Formulario = new JFrame();
    static JList<Object> listaTela;
    static JScrollPane scrollpane;
    static Model m = Model.getInstance();
	
    public static void main(String[] args) {
    	createView();
	} 
  
    public static void createView()
    {
       	Formulario.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    	Formulario.setTitle( "Dados do IDEB(Índice de Desenvolvimento da Educação Básica)" );   
    	Formulario.setSize( 490 , 400 );
    	Formulario.setLocationRelativeTo( null );
    	Painel.setLayout( null ); 
    	Formulario.add( Painel );
    	JLabel Label1 = new JLabel("Link");
    	final JTextField Text1 = new JTextField( "http://www.json-generator.com/api/json/get/ckmQAotvPC?indent=2" );
    	JLabel Label2 = new JLabel("Organizar");
    	JLabel Label3
    	= new JLabel("Campo");
    	JLabel Label4 = new JLabel("Sequencia");   	
    	
    	final JComboBox<String> ComboOrganiza  = new JComboBox<String>();
    	ComboOrganiza.addItem( "Sim");
    	ComboOrganiza.addItem( "Não");
    	
    	final JComboBox<String> ComboCampo  = new JComboBox<String>();
    	ComboCampo.addItem( "Ano" );
    	ComboCampo.addItem( "Estado" );
    	ComboCampo.addItem( "Valor" );
    	
    	final JComboBox<String> ComboOrdem  = new JComboBox<String>();
    	ComboOrdem.addItem( "Asc" );
    	ComboOrdem.addItem( "Desc" );
    	
    	JButton Botao = new JButton("Buscar Dados"); 
    	
    	adiciona( Label1 ,  10 ,  10 ,  70 ,  25 ) ;
        adiciona( Text1  ,  80 ,  10 , 230 ,  25 ) ;
        adiciona( Label2 , 320 ,  10 ,  60 ,  25 ) ;
        adiciona( ComboOrganiza  , 390 ,  10 ,  80 ,  25 ) ; 
        adiciona( Label3 ,  10 ,  15 , 230 , 100 ) ;
        adiciona( ComboCampo  , 80 ,  52 ,  80 ,  25) ; 
        adiciona( Label4 ,  320 ,  15 , 230 , 100 ) ;
        adiciona( ComboOrdem  , 390 ,  52 ,  80 ,  25 ) ; 
        adiciona( Botao  , 150 , 85 ,  150 ,  30 ) ;   
        
        Formulario.setVisible( true );
        Botao.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                         // aqui vai a ação
            	String link = Text1.getText();
            	Boolean organizar;
            	String campo = "";
            	String ordem = "";
            	if(ComboOrganiza.getSelectedItem().toString().equals("Sim"))
            	{
            		organizar = true;
                	campo = ComboCampo.getSelectedItem().toString();
                	ordem = ComboOrdem.getSelectedItem().toString();
            	}
        		else
        			organizar = false;
            	try {
					exibirLista(m.exibirDados(link, organizar, campo, ordem));
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
   });
	}
    
    public static void exibirLista(List<EducacaoMOD> lst)
    {
    	DefaultListModel<String> listModel = new DefaultListModel<>();
    	for(EducacaoMOD e1 : lst)
			listModel.addElement("Estado: " + e1.getEstado() + ", Ano: " + Integer.toString(e1.getAno()) + ", Valor: " + Double.toString(e1.getValor()));
		listaTela = new JList<>(listModel.toArray());
		listaTela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaTela.setVisibleRowCount(12);
		scrollpane = new JScrollPane(listaTela);
		adiciona(scrollpane, 10 , 140 ,  400 ,  200);
		scrollpane.getViewport().add(listaTela);
    }
    
    
    public static void adiciona( Component Componente , int nColuna , int nLinha , int nLargura , int nAltura )  
    {
        //--[ ADICIONA O COMPONENTE NO PAINEL ]--\\
        Painel.add( Componente );
        //--[ SETA A POSICAO EXATA DO COMPONENTE ]--\\
        Componente.setBounds( nColuna , nLinha , nLargura , nAltura );
    }
}	
