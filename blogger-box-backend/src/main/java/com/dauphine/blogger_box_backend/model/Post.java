package com.dauphine.blogger_box_backend.model;

import java.security.Timestamp;
import java.util.UUID;

public class Post {
    UUID id;
    String title;
    String content;
    Timestamp created_date;
    UUID category_id;
}