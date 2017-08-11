package ui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import controlers.CtrlABMPersona;
import entity.Persona;

import java.awt.Color;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoPersonas extends JInternalFrame {
	
	private ArrayList<Persona> pers;
	CtrlABMPersona ctrl= new CtrlABMPersona();
	
	private JTable table;

	/**
	 * Create the frame.
	 */
	public ListadoPersonas() {
		setClosable(true);
		setBounds(100, 100, 507, 300);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnEditarClick();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(368, Short.MAX_VALUE)
					.addComponent(btnEditar)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditar)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(groupLayout);
		
		try{
			this.pers=ctrl.getAll();
		} catch (Exception e){
			JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	
		}
		initDataBindings();
	}
	protected void btnEditarClick() {
		int indexPersona=table.convertRowIndexToModel(table.getSelectedRow());
		
		ABMCPersonaDesktop pd= new ABMCPersonaDesktop();
		pd.showPersona(this.pers.get(indexPersona));
		
		this.getDesktopPane().add(pd);
		pd.setVisible(true);
		
	}
	protected void initDataBindings() {
		JTableBinding<Persona, List<Persona>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, pers, table);
		//
		BeanProperty<Persona, String> personaBeanProperty = BeanProperty.create("nombre");
		jTableBinding.addColumnBinding(personaBeanProperty).setColumnName("Nombre").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_1 = BeanProperty.create("apellido");
		jTableBinding.addColumnBinding(personaBeanProperty_1).setColumnName("Apellido").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_2 = BeanProperty.create("dni");
		jTableBinding.addColumnBinding(personaBeanProperty_2).setColumnName("DNI").setEditable(false);
		//
		BeanProperty<Persona, String> personaBeanProperty_3 = BeanProperty.create("categoria.descripcion");
		jTableBinding.addColumnBinding(personaBeanProperty_3).setColumnName("Categoria").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
