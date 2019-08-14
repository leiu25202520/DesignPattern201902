package com.leiu2520.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Bullet {
    public UUID id = UUID.randomUUID();
    boolean living = true;

    @Override
    public String toString() {
        return "BulletPool{" +
                "id=" + id +
                '}';
    }
}

public class BulletPool{
    List<Bullet> bullets = new ArrayList<>();
    {
        for(int i = 0 ; i<5;i++){
            bullets.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for(int i = 0; i <bullets.size();i++){
            Bullet b = bullets.get(i);
            if(!b.living) return b;
        }
        System.out.println("new");
        return new Bullet();
    }

    public static void main(String[] args){
        BulletPool bp = new BulletPool();

        for(int i = 0; i < 20;i++){
            Bullet b = bp.getBullet();
            System.out.println(b);
        }
    }
}
