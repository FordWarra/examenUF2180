package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Centro;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;

public class DialogoAñadirDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodDepartamento;
	private JTextField txtNombre;
	private Controlador controlador;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBoxCentro;
	private ArrayList<Centro> listaCentros;
	private JRadioButton rdbtnPropiedad;
	private JRadioButton rdbtnEnFunciones;
	private JSpinner spinnerPresupuesto;


	/**
	 * Create the dialog.
	 */
	public DialogoAñadirDepartamento() {
		setBounds(100, 100, 450, 356);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[grow]"));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Detalles del departamento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			((TitledBorder)  panel.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(panel, "cell 0 0,grow");
			panel.setLayout(new MigLayout("", "[][][:50px:50px,grow][:50px:50px][:50px:50px][:50px:50px]", "[][:32px:32px][][:32px:32px][][:32px:32px][][:32px:32px][]"));
			{
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setIcon(new ImageIcon(DialogoAñadirDepartamento.class.getResource("/images/editar32.png")));
				panel.add(lblNewLabel_3, "cell 0 0 1 9");
			}
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo:");
				panel.add(lblNewLabel, "flowy,cell 1 0,alignx trailing");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtCodDepartamento = new JTextField();
				panel.add(txtCodDepartamento, "cell 2 0 4 1,growx");
				txtCodDepartamento.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtCodDepartamento.setColumns(10);
			}
			{
				JLabel lblCdigoCentro = new JLabel("Centro:");
				lblCdigoCentro.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel.add(lblCdigoCentro, "cell 1 2,alignx trailing");
			}
			{
				comboBoxCentro = new JComboBox();
				panel.add(comboBoxCentro, "cell 2 2 4 1,growx");
			}
			{
				JLabel lblTipodir = new JLabel("Tipo_dir:");
				lblTipodir.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel.add(lblTipodir, "cell 1 4,alignx trailing");
			}
			{
				rdbtnPropiedad = new JRadioButton("Propiedad");
				rdbtnPropiedad.setSelected(true);
				buttonGroup.add(rdbtnPropiedad);
				rdbtnPropiedad.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(rdbtnPropiedad, "flowx,cell 2 4 2 1,alignx left");
			}
			{
				rdbtnEnFunciones = new JRadioButton("En funciones");
				buttonGroup.add(rdbtnEnFunciones);
				rdbtnEnFunciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
				panel.add(rdbtnEnFunciones, "cell 4 4 2 1,alignx left");
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Presupuesto:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				panel.add(lblNewLabel_2, "cell 1 6,alignx trailing");
			}
			{
				spinnerPresupuesto = new JSpinner();
				spinnerPresupuesto.setModel(new SpinnerNumberModel(5, 1, 100, 1));
				panel.add(spinnerPresupuesto, "cell 2 6");
			}
			{
				JLabel lblNewLabel_4 = new JLabel("(en miles de \u20AC)");
				panel.add(lblNewLabel_4, "cell 4 6 2 1,alignx left");
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				panel.add(lblNewLabel_1, "cell 1 8,alignx trailing");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}
			{
				txtNombre = new JTextField();
				panel.add(txtNombre, "cell 2 8 4 1,growx");
				txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
				txtNombre.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


	protected void recogerDatos() {
		int cod_departamento = Integer.parseInt(txtCodDepartamento.getText());
		Centro c = (Centro) comboBoxCentro.getSelectedItem();
		char tipo = devolverBotones();
		int presupuesto = (int) spinnerPresupuesto.getValue();
		String nombre = txtNombre.getText();
		Departamento departamento = new Departamento(cod_departamento, c.getCod_centro(), tipo, presupuesto, nombre);
		controlador.insertaDepartamento(departamento);
	}

	public void setListaCentros(ArrayList<Centro> listaCentros) {
		this.listaCentros = listaCentros;
		for (Centro centro : listaCentros) {
			comboBoxCentro.addItem(centro);
		}
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

	
	public char devolverBotones() {
		char tipo;
		
		if (rdbtnPropiedad.isSelected())
			tipo = 'P';
		else
			tipo = 'F';
		
		return tipo;
	}
}
