package factory;

import factory.action.Action;

/*
 * Action을 만들어내는 공장..
 * Action을 만들어내는 메소드가 있어야 한다..createAction(String command)
 * ::
 * createAction()을 하나 정의해 놓자.
 */
public interface Factory {
	Action createAction(String command);
	
}
