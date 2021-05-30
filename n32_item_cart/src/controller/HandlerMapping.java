package controller;

public class HandlerMapping {
   private static HandlerMapping handler = new HandlerMapping();
   private HandlerMapping(){}
   
   public static HandlerMapping getInstance(){
      return handler;
   }
   
   //Controller를 리턴하는 메소드
   public Controller createController(String command){
      Controller controller = null;
      if(command.equals("/itemList.do")){ //이부분 주의!
         controller = new ItemListController();
         System.out.println("ItemListController 생성");
      }
      return controller;
   }
}