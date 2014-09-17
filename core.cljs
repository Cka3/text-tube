(ns text-tube.core
  (:require
    [om.core :as om :include-macros true]
    [om.dom :as dom :include-macros true]
    [text-tube.mutators :as mu]
  ))

(enable-console-print!)
;; define your app data so that it doesn't get over-written on reload
;; (defonce app-data (atom {}))

(defn by-id [id]
  "Short-hand for document.getElementById(id)"
  (. js/document (getElementById id)))

(defn widget-textarea [data]
  (reify
    om/IRender
    (render [this]
      (dom/div nil
               (dom/h3 nil (:title data))
               (dom/textarea #js{:id (:id data) :style #js{:position "relative" :width "500px" :margin "auto"}}
                             (:value data))
               (dom/br nil)
               (dom/button #js{:id (:id-button data)} (:button-text data))))))

(om/root widget-textarea {:value "" :title "Your text goes here:" :button-text "Mutate" :id "source" :id-button "mutate-button"}
         {:target (by-id "my-app")})


