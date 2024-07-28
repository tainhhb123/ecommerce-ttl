<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="connect.Dao"%>
<%@ page import="java.util.Vector"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>TTL</title>

<!-- Meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="description">
<meta name="author" content="Xiaoying Riley at 3rd Wave Media">
<link rel="shortcut icon" href="favicon.ico">

<!-- FontAwesome JS-->
<script defer src="assets/plugins/fontawesome/js/all.min.js"></script>

<!-- App CSS -->
<link id="theme-style" rel="stylesheet" href="assets/css/portal.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

</head>

<body class="app">
	<%
	Dao dao = new Dao();
	Vector listV = dao.getVoucherOfShop(request);
	%>
	<header class="app-header fixed-top">
		<div class="app-header-inner">
			<div class="container-fluid py-2">
				<div class="app-header-content">
					<div class="row justify-content-between align-items-center">

						<div class="col-auto">
							<a id="sidepanel-toggler"
								class="sidepanel-toggler d-inline-block d-xl-none" href="#">
								<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30"
									viewBox="0 0 30 30" role="img">
									<title>Menu</title><path stroke="currentColor"
										stroke-linecap="round" stroke-miterlimit="10" stroke-width="2"
										d="M4 7h22M4 15h22M4 23h22"></path></svg>
							</a>
						</div>
						<!--//col-->
						<div class="search-mobile-trigger d-sm-none col">
							<i
								class="search-mobile-trigger-icon fa-solid fa-magnifying-glass"></i>
						</div>
						<!--//col-->


						<div class="app-utilities col-auto">



							<div class="app-utility-item app-user-dropdown dropdown">
								<a class="dropdown-toggle" id="user-dropdown-toggle"
									data-bs-toggle="dropdown" href="#" role="button"
									aria-expanded="false"><img src="assets/images/user.png"
									alt="user profile"></a>
								<ul class="dropdown-menu" aria-labelledby="user-dropdown-toggle">
									<li><a class="dropdown-item" href="cliaccount.jsp">Account</a></li>
									<li><a class="dropdown-item" href="cusindex.jsp"><i
											class="bi bi-arrow-left-right"></i> Customer</a></li>
									<li><hr class="dropdown-divider"></li>
									<li><a class="dropdown-item" href="login.jsp">Log Out</a></li>
								</ul>
							</div>
							<!--//app-user-dropdown-->
						</div>
						<!--//app-utilities-->
					</div>
					<!--//row-->
				</div>
				<!--//app-header-content-->
			</div>
			<!--//container-fluid-->
		</div>
		<!--//app-header-inner-->
		<div id="app-sidepanel" class="app-sidepanel sidepanel-hidden">
			<div id="sidepanel-drop" class="sidepanel-drop"></div>
			<div class="sidepanel-inner d-flex flex-column">
				<a href="#" id="sidepanel-close" class="sidepanel-close d-xl-none">&times;</a>
				<div class="app-branding">
					<a class="app-logo" href="index.jsp"><img
						class="logo-icon me-2" src="assets/images/app-logo.svg" alt="logo"><span
						class="logo-text">TTL</span></a>

				</div>
				<!--//app-branding-->
				<nav id="app-nav-main" class="app-nav app-nav-main flex-grow-1">
					<ul class="app-menu list-unstyled accordion" id="menu-accordion">
						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link " href="cliindex.jsp"> <span class="nav-icon">
									<svg width="1em" height="1em" viewBox="0 0 16 16"
										class="bi bi-house-door" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
		  <path fill-rule="evenodd"
											d="M7.646 1.146a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 .146.354v7a.5.5 0 0 1-.5.5H9.5a.5.5 0 0 1-.5-.5v-4H7v4a.5.5 0 0 1-.5.5H2a.5.5 0 0 1-.5-.5v-7a.5.5 0 0 1 .146-.354l6-6zM2.5 7.707V14H6v-4a.5.5 0 0 1 .5-.5h3a.5.5 0 0 1 .5.5v4h3.5V7.707L8 2.207l-5.5 5.5z" />
		  <path fill-rule="evenodd"
											d="M13 2.5V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
		</svg>
							</span> <span class="nav-link-text">Overview</span>
						</a> <!--//nav-link-->
						</li>
						<!--//nav-item-->

						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link " href="cliorders.jsp"> <span
								class="nav-icon"> <svg xmlns="http://www.w3.org/2000/svg"
										width="16" height="16" fill="currentColor"
										class="bi bi-box-seam" viewBox="0 0 16 16">
										<path
											d="M8.186 1.113a.5.5 0 0 0-.372 0L1.846 3.5l2.404.961L10.404 2zm3.564 1.426L5.596 5 8 5.961 14.154 3.5zm3.25 1.7-6.5 2.6v7.922l6.5-2.6V4.24zM7.5 14.762V6.838L1 4.239v7.923zM7.443.184a1.5 1.5 0 0 1 1.114 0l7.129 2.852A.5.5 0 0 1 16 3.5v8.662a1 1 0 0 1-.629.928l-7.185 2.874a.5.5 0 0 1-.372 0L.63 13.09a1 1 0 0 1-.63-.928V3.5a.5.5 0 0 1 .314-.464z" />
									  </svg>
							</span> <span class="nav-link-text">Orders</span>
						</a> <!--//nav-link-->
						</li>
						<!--//nav-item-->
						<li class="nav-item has-submenu">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link submenu-toggle " href="#"
							data-bs-toggle="collapse" data-bs-target="#submenu-1"
							aria-expanded="false" aria-controls="submenu-1"> <span
								class="nav-icon"> <!--//Bootstrap Icons: https://icons.getbootstrap.com/ -->
									<svg width="1em" height="1em" viewBox="0 0 16 16"
										class="bi bi-files" fill="currentColor"
										xmlns="http://www.w3.org/2000/svg">
	  <path fill-rule="evenodd"
											d="M4 2h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2zm0 1a1 1 0 0 0-1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1-1V4a1 1 0 0 0-1-1H4z" />
	  <path
											d="M6 0h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2v-1a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1H4a2 2 0 0 1 2-2z" />
	</svg>
							</span> <span class="nav-link-text">Product</span> <span
								class="submenu-arrow"> <svg width="1em" height="1em"
										viewBox="0 0 16 16" class="bi bi-chevron-down"
										fill="currentColor" xmlns="http://www.w3.org/2000/svg">
										<path fill-rule="evenodd"
											d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z" />
									  </svg>
							</span> <!--//submenu-arrow-->
						</a> <!--//nav-link-->
							<div id="submenu-1" class="collapse submenu submenu-1 "
								data-bs-parent="#menu-accordion">
								<ul class="submenu-list list-unstyled">
									<li class="submenu-item"><a class="submenu-link "
										href="clilistproduct.jsp">List Product</a></li>
									<li class="submenu-item"><a class="submenu-link"
										href="cliaddproduct.jsp">Add Product</a></li>



								</ul>
							</div>
						</li>
						<!--//nav-item-->
						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link" href="clicategory.jsp"> <span
								class="nav-icon"> <svg xmlns="http://www.w3.org/2000/svg"
										width="16" height="16" fill="currentColor" class="bi bi-file"
										viewBox="0 0 16 16">
										<path
											d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1" />
									  </svg>
							</span> <span class="nav-link-text">Categorys</span>
						</a> <!--//nav-link-->
						</li>
						<!--//nav-item-->
						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link" href="clibrand.jsp"> <span class="nav-icon">
									<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
										fill="currentColor" class="bi bi-file" viewBox="0 0 16 16">
										<path
											d="M4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm0 1h8a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1" />
									  </svg>
							</span> <span class="nav-link-text">Brands</span>
						</a> <!--//nav-link-->
						</li>
						<!--//nav-item-->

						<li class="nav-item">
							<!--//Bootstrap Icons: https://icons.getbootstrap.com/ --> <a
							class="nav-link active" href="clivoucher.jsp"> <span
								class="nav-icon"> <svg xmlns="http://www.w3.org/2000/svg"
										width="16" height="16" fill="currentColor"
										class="bi bi-cassette" viewBox="0 0 16 16">
										<path
											d="M4 8a1 1 0 1 0 0-2 1 1 0 0 0 0 2m9-1a1 1 0 1 1-2 0 1 1 0 0 1 2 0M7 6a1 1 0 0 0 0 2h2a1 1 0 1 0 0-2z" />
										<path
											d="M1.5 2A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2zM1 3.5a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-.691l-1.362-2.724A.5.5 0 0 0 12 10H4a.5.5 0 0 0-.447.276L2.19 13H1.5a.5.5 0 0 1-.5-.5zM11.691 11l1 2H3.309l1-2z" />
									  </svg>
							</span> <span class="nav-link-text">Vouchers</span>
						</a> <!--//nav-link-->
						</li>
						<!--//nav-item-->


					</ul>
					<!--//app-menu-->
				</nav>
				<!--//app-nav-->

			</div>
			<!--//sidepanel-inner-->
		</div>
		<!--//app-sidepanel-->
	</header>
	<!--//app-header-->

	<div class="app-wrapper">

		<div class="app-content pt-3 p-md-3 p-lg-4">
			<div class="container-xl">

				<div class="row g-3 mb-4 align-items-center justify-content-between">
					<div class="col-auto">
						<h1 class="app-page-title mb-0">Vouchers</h1>
					</div>
					<div class="col-auto">
						<div class="page-utilities">
							<div
								class="row g-2 justify-content-start justify-content-md-end align-items-center">
								<div class="col-auto">
									<form class="table-search-form row gx-1 align-items-center">
										<div class="col-auto">
											<input type="text" id="search-orders" name="searchorders"
												class="form-control search-orders" placeholder="Search">
										</div>
										<div class="col-auto">
											<button type="submit" class="btn app-btn-secondary">
												<i class="bi bi-search"></i>
											</button>
										</div>
									</form>

								</div>
								<!--//col-->

							</div>
							<!--//row-->
						</div>
						<!--//table-utilities-->
					</div>
					<!--//col-auto-->
				</div>
				<!--//row-->
				<div class="row g-4 settings-section mb-5">
					<div class="col-12 col-md-12">
						<div class="app-card app-card-settings shadow-sm p-4">
							<div class="app-card-body">
								<form class="settings-form">
									<div class="row">
										<div class="mb-3 col-2">
											<label for="setting-input-2" class="form-label">Voucher
												Code</label> <input type="text" class="form-control"
												placeholder="Ex: RRRN..." id="setting-input-2" required>
										</div>
										<div class="mb-3 col-2">
											<label for="setting-input-4" class="form-label">Percent
												Discount</label> <input type="number" placeholder="8%..."
												class="form-control" id="setting-input-4" required></input>
										</div>
										<div class="mb-3 col-2">
											<label for="setting-input-2" class="form-label">Condition</label>
											<input type="number" placeholder="100000..."
												class="form-control" id="setting-input-2" required>
										</div>
										<div class="mb-3 col-2">
											<label for="setting-input-2" class="form-label">StartDate</label>
											<input type="date" class="form-control" id="setting-input-2"
												required>
										</div>
										<div class="mb-3 col-2">
											<label for="setting-input-2" class="form-label">EndDate</label>
											<input type="date" class="form-control" id="setting-input-2"
												required>
										</div>
										<div class="mb-3 col-2">
											<label for="setting-input-2" class="form-label">Max
												Discount</label> <input type="number" placeholder="50000..."
												class="form-control" id="setting-input-2" required>
										</div>
									</div>
									<div class="row">
										<div class="form-check form-switch ms-3 col-1">
											<input class="form-check-input" type="checkbox"
												id="settings-switch-1" checked> <label
												class="form-check-label ms-1" for="settings-switch-1">Status</label>
										</div>
										<div class="col-6">
											<button type="submit" class="btn app-btn-primary ">Add
												Voucher</button>
										</div>
									</div>
								</form>
							</div>
							<!--//app-card-body-->

						</div>
						<!--//app-card-->
					</div>
				</div>
				<!--//row-->

				<nav id="orders-table-tab"
					class="orders-table-tab app-nav-tabs nav shadow-sm flex-column flex-sm-row mb-4">
					<a class="flex-sm-fill text-sm-center nav-link active"
						id="orders-all-tab" data-bs-toggle="tab" href="#orders-all"
						role="tab" aria-controls="orders-all" aria-selected="true">All</a>
					<a class="flex-sm-fill text-sm-center nav-link"
						id="orders-active-tab" data-bs-toggle="tab" href="#orders-active"
						role="tab" aria-controls="orders-active" aria-selected="false">Active</a>
					<a class="flex-sm-fill text-sm-center nav-link"
						id="orders-hide-tab" data-bs-toggle="tab" href="#orders-hide"
						role="tab" aria-controls="orders-hide" aria-selected="false">Hide</a>
				</nav>


				<div class="tab-content" id="orders-table-tab-content">
					<div class="tab-pane fade show active" id="orders-all"
						role="tabpanel" aria-labelledby="orders-all-tab">
						<div class="app-card app-card-orders-table shadow-sm mb-5">
							<div class="app-card-body">
								<div class="table-responsive">
									<table class="table app-table-hover mb-0 text-left">
										<thead>
											<tr>
												<th class="cell">Voucher Code</th>
												<th class="cell">Percent Discount</th>
												<th class="cell">Condition</th>
												<th class="cell">StartDate</th>
												<th class="cell">EndDate</th>
												<th class="cell">Max Discount</th>
												<th class="cell">Status</th>
												<th class="cell"></th>
											</tr>
										</thead>
										<tbody>
											<c:set var="result" value="<%=listV%>" />
											<c:if test="${not empty result}">
												<c:forEach var="dto" items="${result}">
													<tr>
														<td class="cell">${dto.get(0)}</td>
														<td class="cell">${dto.get(1)}</td>
														<td class="cell">< ${dto.get(2)}vnd</td>
														<td class="cell">${dto.get(3)}</td>
														<td class="cell">${dto.get(4)}</td>
														<td class="cell">${dto.get(5)}</td>
														<c:if test="${dto.get(7) == 1}">
															<td class="cell"><a
																href="?vouchercode=${dto.get(0)}&status=${dto.get(3)}"><span
																	class="badge bg-success">Hide</span></a></td>
														</c:if>
														<c:if test="${dto.get(7) == 0}">
															<td class="cell"><a
																href="?vouchercode=${dto.get(0)}&status=${dto.get(3)}"><span
																	class="badge bg-danger">Active</span></a></td>
														</c:if>
														<td class="cell"><a class="btn-sm app-btn-secondary"
															href="#">edit</a></td>
													</tr>
												</c:forEach>
											</c:if>
										</tbody>
									</table>
								</div>
								<!--//table-responsive-->

							</div>
							<!--//app-card-body-->
						</div>
						<!--//app-card-->


					</div>
					<!--//tab-pane-->

					<div class="tab-pane fade" id="orders-active" role="tabpanel"
						aria-labelledby="orders-active-tab">
						<div class="app-card app-card-orders-table mb-5">
							<div class="app-card-body">
								<div class="table-responsive">

									<table class="table mb-0 text-left">
										<thead>
											<tr>
												<th class="cell">Voucher Code</th>
												<th class="cell">Percent Discount</th>
												<th class="cell">Condition</th>
												<th class="cell">StartDate</th>
												<th class="cell">EndDate</th>
												<th class="cell">Max Discount</th>
												<th class="cell">Status</th>
												<th class="cell"></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="cell">#15346</td>
												<td class="cell">12%</td>
												<td class="cell">100000vnd</td>
												<td class="cell">12/12/20024</td>
												<td class="cell">12/12/20024</td>
												<td class="cell">50000vnd</td>
												<td class="cell"><span class="badge bg-success">Paid</span></td>
												<td class="cell"><a class="btn-sm app-btn-secondary"
													href="#">edit</a></td>
											</tr>



										</tbody>
									</table>
								</div>
								<!--//table-responsive-->
							</div>
							<!--//app-card-body-->
						</div>
						<!--//app-card-->
					</div>
					<!--//tab-pane-->

					<div class="tab-pane fade" id="orders-hide" role="tabpanel"
						aria-labelledby="orders-hide-tab">
						<div class="app-card app-card-orders-table mb-5">
							<div class="app-card-body">
								<div class="table-responsive">
									<table class="table mb-0 text-left">
										<thead>
											<tr>
												<th class="cell">Voucher Code</th>
												<th class="cell">Percent Discount</th>
												<th class="cell">Condition</th>
												<th class="cell">StartDate</th>
												<th class="cell">EndDate</th>
												<th class="cell">Max Discount</th>
												<th class="cell">Status</th>
												<th class="cell"></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td class="cell">#15346</td>
												<td class="cell">12%</td>
												<td class="cell">100000vnd</td>
												<td class="cell">12/12/20024</td>
												<td class="cell">12/12/20024</td>
												<td class="cell">50000vnd</td>
												<td class="cell"><span class="badge bg-danger">Paid</span></td>
												<td class="cell"><a class="btn-sm app-btn-secondary"
													href="#">edit</a></td>
											</tr>
										</tbody>
									</table>
								</div>
								<!--//table-responsive-->
							</div>
							<!--//app-card-body-->
						</div>
						<!--//app-card-->
					</div>
					<!--//tab-pane-->

				</div>
				<!--//tab-content-->



			</div>
			<!--//container-fluid-->
		</div>
		<!--//app-content-->

		<footer class="app-footer"> </footer>
		<!--//app-footer-->

	</div>
	<!--//app-wrapper-->


	<!-- Javascript -->
	<script src="assets/plugins/popper.min.js"></script>
	<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>


	<!-- Page Specific JS -->
	<script src="assets/js/app.js"></script>

</body>
</html>

