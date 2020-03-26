(ns views.products.show-product-test
  (:require [views.products.show-product :refer [show-product-component]]
            [specs.products.show-product :as spec]
            [clojure.spec.alpha :as s]
            [clojure.test.check.generators :as gen]
            [devcards.core :refer-macros [defcard-rg]]))

(defn- show-product* [m]
  (if (s/valid? ::spec/component m)
    [show-product-component m]
    [:div.error
     [:h4 "Bad input"]
     [:pre [:code (s/explain-str ::spec/component m)]]]))

(defcard-rg show-product
  [:div
   [:h1 [:i "Initial state"]]
   [show-product* {}]])

(defcard-rg generated-show-product
  (let [models (gen/sample (s/gen ::spec/component))]
    [:div
     (map-indexed (fn [i m]
                    [:div {:key i}
                     [:pre (pr-str m)]
                     [show-product* m]])
                  models)]))

(s/def ::name string?)
(gen/sample (s/gen ::spec/component))
