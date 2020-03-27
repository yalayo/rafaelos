(ns views.products.show-product
  (:require [specs.products.show-product :as spec]
            [clojure.spec.alpha :as s]
            [re-frame.core :as re-frame]))

(defn show-product-component [model]
  (let [product (get model :product)
        name (get product :name)
        image (get product :image)]
    [:div
     [:p name]
     [:p image]]))


