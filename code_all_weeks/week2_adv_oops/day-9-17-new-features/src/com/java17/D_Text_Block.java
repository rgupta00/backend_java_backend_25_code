package com.java17;

public class D_Text_Block {
    public static void main(String[] args) {

        String sql = """
      SELECT id, firstName, lastName
        FROM Employee
       WHERE departmentId = "IT"
    ORDER BY lastName, firstName""";


        String html = """
        <html>
          <body>
            <p>Hello World!</p>
          </body>
        </html>""";
        System.out.println(html);
    }

}
