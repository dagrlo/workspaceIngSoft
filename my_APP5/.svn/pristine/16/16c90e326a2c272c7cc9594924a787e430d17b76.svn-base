package es.uv.isw.app5.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import es.uv.isw.app5.actions.Action;

public class WorkflowDispatcher implements Dispatcher {
	private static final String WORKFLOW_TAG = "workflow";
	private static final String STATE_TAG = "state";
	private static final String NAME_ATTR = "name";
	private static final String ACTION_ATTR = "action";
	private static final String VIEW_ATTR = "viewURI";
	
	// where to find action classes
	private static final String ACTION_PREFIX = "es.uv.isw.app5.actions.";
	
	// The internal model of a workflow state
	class State {
		protected String name;
		protected Action action;
		protected String viewUri;
	}
	
	// The current state and state list
	private State[] states;
	private int currentState;
	
	@Override
	public void setContext(ServletContext context) throws IOException {
		InputStream is = context.getResourceAsStream("/LanguageWorkflow.xml");
		try {
			states = paseXML(is);
		} 
		catch (Exception ex) {
			throw new IOException(ex.getMessage());
		}
		currentState = 0;
	}

	@Override
	public String getNextPage(HttpServletRequest req, ServletContext context) {
		State s = states[currentState];
		// Increment the state only if the actions succeeds
		if ((s.action == null) || s.action.performAction(req, context)) {
			if (currentState < states.length -1) {
				s = states[++currentState];
			}
			else {
				currentState = 0;
				s = states[currentState];
			}
		}
		System.out.println("WorkflowDispatcher: viewUri: " + s.viewUri);
		return s.viewUri;
	}
	
	// Parse a state XML file
	private State[] paseXML(InputStream is) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = (Document) builder.parse(is);
		
		// Find the workflow element
		NodeList workflows = doc.getElementsByTagName(WORKFLOW_TAG);
		Element workflow = (Element)workflows.item(0);
		
		// Find all the states
		NodeList states = doc.getElementsByTagName(STATE_TAG);
		State[] stateList = new State[states.getLength()];
		
		// Read state information
		for (int i = 0; i < states.getLength(); i++) {
			stateList[i] = new State();
		
			Element curState = (Element)states.item(i);
			stateList[i].name = curState.getAttribute(NAME_ATTR);
			stateList[i].viewUri = curState.getAttribute(VIEW_ATTR);
			
			// Convert action names into class instances
			String action = curState.getAttribute(ACTION_ATTR);
			if (action != null && action.length() > 0) {
				Class<?> c = Class.forName(ACTION_PREFIX + action);
				stateList[i].action = (Action)c.newInstance();
			}
		}
		return stateList;
	}
}
