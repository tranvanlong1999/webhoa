<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--new-->
<div class="new">
	<div class="container">
		<div class="title-info wow fadeInUp animated" data-wow-delay=".5s">
			<h3 class="title">BÁN CHẠY</h3>
			<p>TOP 4 SẢN PHẨM BÁN CHẠY NHẤT</p>
		</div>
		<div class="new-info">
			<div class="col-md-3 new-grid simpleCart_shelfItem wow flipInY animated"
				data-wow-delay=".5s">
				<div class="new-top">
					<a href="single.html"><img src="static/images/phone/suavina.jpg"
						class="img-responsive" alt="" /></a>
					<div class="new-text">
						<ul>
							<li><a class="item_add" href="">Xem Chi Tiết </a></li>
							<li><input type="number" class="item_quantity" min="1" value="1"></li>
							<li><a href="">Thêm vào Giỏ </a></li>
						</ul>
					</div>
				</div>
				<div class="new-bottom">
					<h5>
						<a class="name" href="single.html" style="font-family: Arial;">Sữa Bột Vinamilk</a>
					</h5>
					<div class="rating">
						<span class="on">☆</span> <span class="on">☆</span> <span class="on">☆</span>
						<span class="on">☆</span> <span class="on">☆</span>
					</div>
					<div class="ofr">
						<p>
							<span class="item_price">500.000đ</span>
						</p>
					</div>
				</div>
			</div>
			<div
				class="col-md-3 new-grid new-mdl simpleCart_shelfItem wow flipInY animated"
				data-wow-delay=".7s">
				<div class="new-top">
					<a href="single.html"><img src="static/images/phone/ensure.jpg"
						class="img-responsive" alt="" /></a>
					<div class="new-text">
						<ul>
							<li><a class="item_add" href="">Xem Chi Tiết </a></li>
							<li><input type="number" class="item_quantity" min="1" value="1"></li>
							<li><a href="">Thêm vào Giỏ </a></li>
						</ul>
					</div>
				</div>
				<div class="new-bottom">
					<h5>
						<a class="name" href="single.html">Sữa Bột Ensure Úc</a>
					</h5>
					<div class="rating">
						<span class="on">☆</span> <span class="on">☆</span> <span class="on">☆</span>
						<span class="on">☆</span> <span class="on">☆</span>
					</div>
					<div class="ofr">
						<p>
							<span class="item_price">500.000đ</span>
						</p>
					</div>
				</div>
			</div>
			<div
				class="col-md-3 new-grid new-mdl1 simpleCart_shelfItem wow flipInY animated"
				data-wow-delay=".9s">
				<div class="new-top">
					<a href="single.html"><img src="static/images/phone/dielac.jpg"
						class="img-responsive" alt="" /></a>
					<div class="new-text">
						<ul>
							<li><a class="item_add" href="">Xem Chi Tiết </a></li>
							<li><input type="number" class="item_quantity" min="1" value="1"></li>
							<li><a href="">Thêm vào Giỏ </a></li>
						</ul>
					</div>
				</div>
				<div class="new-bottom">
					<h5>
						<a class="name" href="single.html">Sữa Bột Dielac</a>
					</h5>
					<div class="rating">
						<span class="on">☆</span> <span class="on">☆</span> <span class="on">☆</span>
						<span class="on">☆</span> <span class="on">☆</span>
					</div>
					<div class="ofr">
						<p>
							<span class="item_price">500.000đ</span>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 new-grid simpleCart_shelfItem wow flipInY animated"
				data-wow-delay="1.1s">
				<div class="new-top">
					<a href="single.html"><img src="static/images/phone/pedia.jpg"
						class="img-responsive" alt="" /></a>
					<div class="new-text">
						<ul>
							<li><a class="item_add" href="">Xem Chi Tiết </a></li>
							<li><input type="number" class="item_quantity" min="1" value="1"></li>
							<li><a href="">Thêm vào Giỏ </a></li>
						</ul>
					</div>
				</div>
				<div class="new-bottom">
					<h5>
						<a class="name" href="single.html">Sữa Bột Pediasure</a>
					</h5>
					<div class="rating">
						<span class="on">☆</span> <span class="on">☆</span> <span class="on">☆</span>
						<span class="on">☆</span> <span class="on">☆</span>
					</div>
					<div class="ofr">
						<p>
							<span class="item_price">500.000đ</span>
						</p>
					</div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--//new-->
<!--gallery-->
<div class="gallery">
	<div class="container">
		<div class="title-info wow fadeInUp animated" data-wow-delay=".5s">
			<h3 class="title">XEM NHIỀU NHẤT</h3>
			<p>SẢN PHẨM CÓ SỐ LƯỢT XEM NHIỀU NHẤT</p>
		</div>
		<div class="gallery-info">
			<c:forEach var="product" varStatus="status" items="${mostViews}">
				<div class="col-md-3 gallery-grid wow fadeInUp animated" data-wow-delay=".5s">
					<a href="productDetail?cateID=${product.category.id}&productID=${product.id}">
						<img src="${product.image}", width="100%", height="180px" />
					</a>
					<div class="gallery-text simpleCart_shelfItem" style="padding-top: 10px;">
						<h6>
							<a class="name" href="productDetail?cateID=${product.category.id}&productID=${product.id}">${product.name}</a>
						</h6>
						<p>
							<span class="item_price">${product.price} VND</span>
						</p>
						<h4 class="sizes"></h4>
						<ul>
							<li>
								<a href="#">
									<span class="glyphicon glyphicon-globe" aria-hidden="true"></span>
								</a>
							</li>
							<li>
								<a class="item_add" href="#">
									<span class="glyphicon glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
								</a>
							</li>
							<li>
								<a href="#">
									<span class="glyphicon glyphicon glyphicon-heart-empty" aria-hidden="true"></span>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--//gallery-->