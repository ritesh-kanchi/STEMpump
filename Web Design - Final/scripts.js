// add domain name to make links and sharing easier
var domain = "stempump";

// give data, everything starts at 0
var title = ["Test 1", "Test 2", "Test 3", "Test 4"];
var dates = ["1/1/19", "1/2/19", "1/3/19", "1/4/19"];
var summaries = ["summary 1", "summary 2", "summary 3", "summary 4"];
var text = ["text 1", "text 2", "text 3", "text 4"];
var links = ["1", "2", "3", "4"];
var grads = ["#00f260, #0575e6", "#12c2e9,#c471ed,#f64f59", "#f12711, #f5af19", "#8E2DE2, #4A00E0"];

// function that creates every card for the posts
function getPosts() {
  // for the number of cards, create them. if you add more data, this auto-updates
	for (var i = 0; i < title.length; i++) {
		document.write("<div style=\"margin-top: 20px;\"></div><div class=\"card\"><div class=\"card-body\"> <h5 class=\"card-title\">" + title[i] + "</h5><h6 class=\"card-subtitle mb-2 text-muted\">" + dates[i] + "</h6><p class=\"card-text\">" + summaries[i] + "</p><a href=\"https://" + domain + ".neocities.org/post" + links[i] + ".html\" class=\"card-link\">View Post</a><a href=\"" + "sms://&body=https://"+domain+".neocities.org/post" + links[i] + ".html\" class=\"card-link\"><i class=\"fas fa-share-square\"></i></a></div><div style=\"margin-bottom: 10px;background: linear-gradient(to right, " + grads[i] + "); width: 100%; height: 10px;\"></div></div>");
	}

}

// function to get the page title the same as the blog post title
function pageTitle(i) {
	document.write("<title>" + title[i] + "</title>");
}

// function that uses the data to create the blog post pages
function post(i) {
	document.write("<h1 class=\"blog-title\">" + title[i] + "</h1><p class=\"blog-title\">" + summaries[i] + "</p><div style=\"margin-top: 30px;\"></div><p class=\"blog-title lead\">" + text[i] + "</p><div style=\"height: 40px; width: 100%;\"></div>");

}

/* function gradient(i) {
  document.write("<div style=\"height: 10px; width: 100%; background: linear-gradient(to right, " + grads[i] + ");\"></div>");
  } */