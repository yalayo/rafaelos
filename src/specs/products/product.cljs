(ns specs.products.product
  (:require [clojure.spec.alpha :as s]))

(s/def ::name string?)
(s/def ::image string?)

(s/def ::product
  (s/keys :req-un [::name ::image]))
