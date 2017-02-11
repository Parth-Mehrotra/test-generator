package com.parthmehrotra.test_generator;

import java.io.FileInputStream;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.IfStmt;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("Location.java");

		CompilationUnit cu;
		cu = JavaParser.parse(in);
		in.close();

		new MethodVisitor().visit(cu, null);
	}
	/**
	 * Simple visitor implementation for visiting MethodDeclaration nodes. 
	 */
	private static class MethodVisitor extends VoidVisitorAdapter {

		@Override
		public void visit(MethodDeclaration n, Object arg) {
			System.out.println(n.getName());
			new IfVisitor().visit(n, "Hello");
		}
	}

	private static class IfVisitor extends VoidVisitorAdapter {
		@Override
		public void visit(IfStmt n, Object arg) {
			System.out.println(arg);
			System.out.println(n);
		}
	}
}
