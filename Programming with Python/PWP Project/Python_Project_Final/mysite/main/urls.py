from django.urls import path
from django.conf.urls import url
from . import views

urlpatterns = [
    path("",views.home,name="home"),
    path('home/', views.home,name="typedhome"),
    url(r'^$', views.home, name='typedhome'),
    url(r"^home/$",views.home,name="typedhome"),
    url(r"^hometime/$",views.home,name="typedhome"),
    url(r"^homecat/$",views.home,name="typedhome"),
    path("result/",views.result,name="result"),
]