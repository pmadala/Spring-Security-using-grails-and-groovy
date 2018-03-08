<head>
<meta name='layout' content='post' />
<title>Login</title>
</head>

<body>
	<div id='login'>
		<div class='inner'>
			<g:if test='${flash.message}'>
			<div class='login_message'>${flash.message}</div>
			</g:if>
			<div class='fheader'>Please Login..</div>
			<form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
				<p>
					<label for='username'>Login ID</label>
					<input type='text' class='text_' name='j_username' id='username' />
				</p>
				<p>
					<label for='password'>Password</label>
					<input type='password' class='text_' name='j_password' id='password' />
				</p>
			
				<p>
					<g:if test="${username == 'admin'}">
					    <input type='submit' value='Login' action='testuseradmin' />
					</g:if>
					<g:elseif >
					    <input type='submit' value='Login' action='testuser' />
					</g:elseif>
				</p>
			</form>
		</div>
	</div>
<script type='text/javascript'>
<!--
(function(){
	document.forms['loginForm'].elements['j_username'].focus();
})();
// -->
</script>
</body>
