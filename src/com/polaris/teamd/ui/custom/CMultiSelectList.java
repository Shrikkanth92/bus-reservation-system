package com.polaris.teamd.ui.custom;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;

import com.polaris.teamd.ui.custom.CSingleSelectInputTable.InnerTableModel;
/**
 * 
 * @author manochitra.sridharan
 *
 * @param <E>
 */
public class CMultiSelectList<E> extends CList{
	ArrayList<E> arrayList = new ArrayList<E>();
	InnerListModel listModel;
	String name;
	Class c;
	public CMultiSelectList() {
		
		super();
		
		
	}
	public InnerListModel createListModel(int[] colCount, String[] colName,Class c){
		return new InnerListModel( colCount,  colName,c);
	}
	public CMultiSelectList(ListModel dataModel) {
		super(dataModel);
	}

	public CMultiSelectList(int[] colCount, String[] colName,E... listData) {
		super(listData);
		listModel=(InnerListModel)createListModel(colCount,colName,listData.getClass());
		this.setModel(listModel);
		for(int i=0;i<listData.length;i++){
		listModel.cAddObject(listData[i]);
		this.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		}
	}

	public CMultiSelectList(Vector<?> listData) {
		super(listData);
	}
	/*public void cAddObject(E e){
		
		listModel.cAddObject(e);
		
	}*/
	public Object cGetSelectedObjects(int[] index) {

		return listModel.cGetSelectedObjects(index);

	}
	public void cSetFieldToDisplay(String field){
		this.name=field;
		
	}
	public String cGetFieldToDisplay(){
	return name;
		
	}
	public Object cGetSelectedObjectsProperties(int[] index, String caption) {
		return listModel.cGetSelectedObjectsProperties(index, caption);
	}
	class InnerListModel implements ListModel{
		int[]index;
		/*String[]name;
		Field[] fields;*/
		
		Class c;
		public InnerListModel(int[] x, String[] name,Class c) {
			/*this.index = x;
			this.name = name;*/
			this.c = c;
			/*CList list=new CList();
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);*/
		}

		public void cAddObject(E e){
			
			
			c=e.getClass();
			/*fields = c.getDeclaredFields();
			index = new int[fields.length];
			name = new String[fields.length];*/
			
			arrayList.add(e);
			
			
			
		}
		@Override
		public int getSize() {
			
			return arrayList.size();
			
		}

		@Override
		public Object getElementAt(int index) {
			E element= arrayList.get(index);
			return cInvokeMethod(cGetFieldToDisplay(),element);
		}
		
		@Override
		public void addListDataListener(ListDataListener l) {
			
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
			
		}
		public String cGetMethodName(String caption) {

			StringBuffer sb = new StringBuffer(caption);
			char a = caption.charAt(0);

			if ((int) a >= 97 && (int) a <= 122) {
				int b = a - 32;
				char c1 = (char) b;
				sb = new StringBuffer(caption);
				sb.deleteCharAt(0);
				sb.insert(0, c1);
			}
			String methodName = "get" + sb.toString();
			
			return methodName;
		}
		public Object cInvokeMethod(String caption, Object element) {
			Method method;
			Object result = null;
			
			String methodToInvoke;
			try {
				methodToInvoke = cGetMethodName(caption);

				method = c.getMethod(methodToInvoke);
				result = method.invoke(element);

			} catch (SecurityException e1) {
				e1.printStackTrace();
			} catch (NoSuchMethodException e1) {
				e1.printStackTrace();
			}

			catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			
			return result;
		}
		public Collection cGetSelectedObjects(int[] index) {
			Collection collection=new ArrayList<E>();
			for(int i=0;i<index.length;i++){
			E e = arrayList.get(index[i]);
			collection.add(e);
			}
			return collection;
			

		}

		public Collection cGetSelectedObjectsProperties(int[] index, String caption) {
			Collection collection=new ArrayList<E>();
		
			for(int i=0;i<index.length;i++){
			Object result= cInvokeMethod(caption,arrayList.get(index[i]));
			collection.add(result);
			}
			return collection;
		}
	}
}


