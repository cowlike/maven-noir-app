(ns my-website.views.todo
  (:require [my-website.views.common :as common])
  (:use noir.core
        hiccup.core
        hiccup.page-helpers))

(defpartial todo-item [{:keys [id title due]}]
    [:li {:id id} ;; maps define HTML attributes
        [:h3 title]
        [:span.due due]]) ;; add a class

(defpartial todos-list [items]
  [:ul#todoItems ;; set the id attribute
   (map todo-item items)])

(defpage "/todo" []
  (todos-list [{:id "todo1" :title "Get Milk" :due "today"}
               {:id "second" :title "Browse" :due "whenever"}
               {:id "todo3" :title "Go Running" :due "today"}]))

