/*
Coded by Joey Yap, Ken Xu
04/09/2023 :: UPDATED 04/12/2023
*/
package usc_mealmatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin: ", "*");
		resp.setContentType("application/json");

		BufferedReader in = req.getReader();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		EmailPassword curr = gson.fromJson(in, EmailPassword.class);

		String email = curr.getEmail();
		String password = curr.getPassword();
		int userID = UserAuthenticator.signup(email, password);

		PrintWriter pw = resp.getWriter();

		if (userID >= 0) {
			// setting status
			resp.setStatus(200);
			pw.print("{\"signup\": true, \"userID\": \"" + userID + "\"}");
			pw.flush();
		} else {
			resp.setStatus(400);
			pw.print("{\"signup\": false}");
			pw.flush();
		}

		pw.close();
		in.close();
	}
}
