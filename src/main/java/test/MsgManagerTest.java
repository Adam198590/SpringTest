package test;

import java.util.List;

import junit.framework.TestCase;
import logic.MsgManager;
import logic.UserMsg;

public class MsgManagerTest extends TestCase {
	MsgManager manager = null;
	
	protected void setUp() throws Exception {
		manager = new MsgManager();
	}
	
	public void testAdd() throws Exception {
		manager.addNewMsg("name1", "msg1");
		assertNotNull(manager.getUsualList().get(0));		
		assertEquals("name1", manager.getUsualList().get(0).getUserName());
		assertEquals("msg1", manager.getUsualList().get(0).getUserMessage());
        assertFalse(manager.getUsualList().isEmpty());
        
        manager.getUsualList().clear();
	}
	
	public void testSize() throws Exception {
		assertEquals(0, manager.getUsualList().size());
		manager.addNewMsg("name1", "msg1");		
        assertEquals(1, manager.getUsualList().size());
        
        manager.getUsualList().clear();
	}
	
	public void testSort() throws Exception {	
		manager.addNewMsg("name2", "msg3");
		manager.addNewMsg("name1", "msg1");
		manager.addNewMsg("name3", "msg2");
		assertEquals(3, manager.getUsualList().size());
		
		List<UserMsg> rez = manager.getSortedList(MsgManager.SortType.NAME);
		assertEquals("name1", rez.get(0).getUserName());
		assertEquals("name2", rez.get(1).getUserName());
		assertEquals("name3", rez.get(2).getUserName());
		
		rez = manager.getSortedList(MsgManager.SortType.CREATE_TIME);
		assertEquals("name2", rez.get(0).getUserName());
		assertEquals("name1", rez.get(1).getUserName());
		assertEquals("name3", rez.get(2).getUserName());		
	}
}