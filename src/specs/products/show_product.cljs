(ns specs.products.show-product
  (:require [clojure.spec.alpha :as s]
            [specs.products.product :as p]))

(s/def ::component
  (s/keys :req-un [::p/product]))
